package Q16_22_Langtons_Ant

import scala.collection.mutable.HashSet

class Board {
  private val blackCells = HashSet[Position]()
  private val ant = new Ant()
  private val topLeftCorner = new Position(0, 0)
  private val bottomRightCorner = new Position(0, 0)

  def move(): Unit = {
    ant.turn(!isBlack(ant.position))
    flip(ant.position)
    ant.move()
    ensureFit(ant.position)
  }

  private def flip(position: Position): Unit = {
    if (blackCells.contains(position)) {
      blackCells.remove(position)
    } else {
      blackCells.add(position.clone().asInstanceOf[Position])
    }
  }

  private def ensureFit(position: Position): Unit = {
    topLeftCorner.row = Math.min(topLeftCorner.row, position.row)
    topLeftCorner.column = Math.min(topLeftCorner.column, position.column)

    bottomRightCorner.row = Math.max(bottomRightCorner.row, position.row)
    bottomRightCorner.column = Math.max(bottomRightCorner.column, position.column)
  }

  def isBlack(p: Position): Boolean = blackCells.contains(p)

  def isBlack(row: Int, column: Int): Boolean = blackCells.contains(new Position(row, column))

  override def toString: String = {
    val sb = new StringBuilder
    val rowMin = topLeftCorner.row
    val rowMax = bottomRightCorner.row
    val colMin = topLeftCorner.column
    val colMax = bottomRightCorner.column

    for (r <- rowMin to rowMax) {
      for (c <- colMin to colMax) {
        sb.append {
          if (r == ant.position.row && c == ant.position.column) ant.orientation
          else if (isBlack(r, c)) "X"
          else "_"
        }
      }
      sb.append("\n")
    }
    sb.append(s"Ant: ${ant.orientation}. \n")
    sb.toString
  }
}
