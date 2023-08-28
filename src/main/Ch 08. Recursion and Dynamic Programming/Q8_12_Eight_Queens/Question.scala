object Question {
  val GRID_SIZE = 8

  def checkValid(columns: Array[Int], row1: Int, column1: Int): Boolean = {
    for (row2 <- 0 until row1) {
      val column2 = columns(row2)
      if (column1 == column2) {
        return false
      }
      val columnDistance = Math.abs(column2 - column1)
      val rowDistance = row1 - row2
      if (columnDistance == rowDistance) {
        return false
      }
    }
    true
  }

  def placeQueens(row: Int, columns: Array[Int], results: scala.collection.mutable.ArrayBuffer[Array[Int]]): Unit = {
    if (row == GRID_SIZE) {
      results += columns.clone()
    } else {
      for (col <- 0 until GRID_SIZE) {
        if (checkValid(columns, row, col)) {
          columns(row) = col
          placeQueens(row + 1, columns, results)
        }
      }
    }
  }

  def clear(columns: Array[Int]): Unit = {
    for (i <- 0 until GRID_SIZE) {
      columns(i) = -1
    }
  }

  def printBoard(columns: Array[Int]): Unit = {
    drawLine()
    for (i <- 0 until GRID_SIZE) {
      print("|")
      for (j <- 0 until GRID_SIZE) {
        if (columns(i) == j) {
          print("Q|")
        } else {
          print(" |")
        }
      }
      println()
      drawLine()
    }
    println()
  }

  def drawLine(): Unit = {
    println("-" * (GRID_SIZE * 2 + 1))
  }

  def printBoards(boards: scala.collection.mutable.ArrayBuffer[Array[Int]]): Unit = {
    boards.foreach(printBoard)
  }

  def main(args: Array[String]): Unit = {
    val results = scala.collection.mutable.ArrayBuffer[Array[Int]]()
    val columns = new Array[Int](GRID_SIZE)
    clear(columns)
    placeQueens(0, columns, results)
    printBoards(results)
    println(results.size)
  }
}
