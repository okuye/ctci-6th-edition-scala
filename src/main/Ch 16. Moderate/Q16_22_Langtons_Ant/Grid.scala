package Q16_22_Langtons_Ant

class Grid {
  private var grid: Array[Array[Boolean]] = Array(Array(false))
  private val ant = new Ant()

  private def copyWithShift(oldGrid: Array[Array[Boolean]], newGrid: Array[Array[Boolean]], shiftRow: Int, shiftColumn: Int): Unit = {
    for (r <- oldGrid.indices) {
      for (c <- oldGrid(r).indices) {
        newGrid(r + shiftRow)(c + shiftColumn) = oldGrid(r)(c)
      }
    }
  }

  private def ensureFit(position: Position): Unit = {
    var shiftRow = 0
    var shiftColumn = 0

    var numRows = grid.length
    if (position.row < 0) {
      shiftRow = numRows
      numRows *= 2
    } else if (position.row >= numRows) {
      numRows *= 2
    }

    var numColumns = grid(0).length
    if (position.column < 0) {
      shiftColumn = numColumns
      numColumns *= 2
    } else if (position.column >= numColumns) {
      numColumns *= 2
    }

    if (numRows != grid.length || numColumns != grid(0).length) {
      val newGrid = Array.ofDim[Boolean](numRows, numColumns)
      copyWithShift(grid, newGrid, shiftRow, shiftColumn)
      ant.adjustPosition(shiftRow, shiftColumn)
      grid = newGrid
    }
  }

  private def flip(position: Position): Unit = {
    grid(position.row)(position.column) = !grid(position.row)(position.column)
  }

  def move(): Unit = {
    ant.turn(!grid(ant.position.row)(ant.position.column))
    flip(ant.position)
    ant.move()
    ensureFit(ant.position)
  }

  override def toString: String = {
    var firstActiveRow = grid.length
    var firstActiveColumn = grid(0).length
    var lastActiveRow = 0
    var lastActiveColumn = 0

    for (r <- grid.indices) {
      for (c <- grid(r).indices) {
        if (grid(r)(c) || (ant.position.row == r && ant.position.column == c)) {
          firstActiveRow = Math.min(firstActiveRow, r)
          firstActiveColumn = Math.min(firstActiveColumn, c)
          lastActiveRow = Math.max(lastActiveRow, r)
          lastActiveColumn = Math.max(lastActiveColumn, c)
        }
      }
    }

    val sb = new StringBuilder
    for (r <- firstActiveRow to lastActiveRow) {
      for (c <- firstActiveColumn to lastActiveColumn) {
        sb.append {
          if (r == ant.position.row && c == ant.position.column) ant.orientation
          else if (grid(r)(c)) "X"
          else "_"
        }
      }
      sb.append("\n")
    }
    sb.append(s"Ant: ${ant.orientation}. \n")
    sb.toString
  }
}
