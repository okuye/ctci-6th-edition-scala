package Q7_09_Minesweeper
import Q7_10_Minesweeper.GameState

import Q7_10_Minesweeper.{Cell, UserPlay, UserPlayResult}

import scala.collection.mutable.Queue
import scala.util.Random

class Board(r: Int, c: Int, b: Int) {
  private val nRows = r
  private val nColumns = c
  private val nBombs = b
  private val cells = Array.ofDim[Cell](nRows, nColumns)
  private val bombs = new Array[Cell](nBombs)
  private var numUnexposedRemaining = nRows * nColumns - nBombs

  initializeBoard()
  shuffleBoard()
  setNumberedCells()

  private def initializeBoard(): Unit = {
    for {
      r <- 0 until nRows
      c <- 0 until nColumns
    } cells(r)(c) = new Cell(r, c)

    for (i <- 0 until nBombs) {
      val r = i / nColumns
      val c = (i - r * nColumns) % nColumns
      bombs(i) = cells(r)(c)
      bombs(i).setBomb(true)
    }
  }

  private def shuffleBoard(): Unit = {
    val nCells = nRows * nColumns
    val random = new Random()
    for (index1 <- 0 until nCells) {
      val index2 = index1 + random.nextInt(nCells - index1)
      if (index1 != index2) {
        val row1 = index1 / nColumns
        val column1 = (index1 - row1 * nColumns) % nColumns
        val cell1 = cells(row1)(column1)

        val row2 = index2 / nColumns
        val column2 = (index2 - row2 * nColumns) % nColumns
        val cell2 = cells(row2)(column2)

        cells(row1)(column1) = cell2
        cell2.setRowAndColumn(row1, column1)
        cells(row2)(column2) = cell1
        cell1.setRowAndColumn(row2, column2)
      }
    }
  }

  private def inBounds(row: Int, column: Int): Boolean = {
    row >= 0 && row < nRows && column >= 0 && column < nColumns
  }

  private def setNumberedCells(): Unit = {
    val deltas = Array(
      (-1, -1),
      (-1, 0),
      (-1, 1),
      (0, -1),
      (0, 1),
      (1, -1),
      (1, 0),
      (1, 1)
    )

    for (bomb <- bombs) {
      val row = bomb.getRow
      val col = bomb.getColumn
      for (delta <- deltas) {
        val r = row + delta._1
        val c = col + delta._2
        if (inBounds(r, c)) {
          cells(r)(c).incrementNumber()
        }
      }
    }
  }

  def printBoard(showUnderside: Boolean): Unit = {
    println()
    print("   ")
    for (i <- 0 until nColumns) {
      print(i + " ")
    }
    println()
    for (_ <- 0 until nColumns) {
      print("--")
    }
    println()
    for (r <- 0 until nRows) {
      print(r + "| ")
      for (c <- 0 until nColumns) {
        if (showUnderside) {
          print(cells(r)(c).getUndersideState)
        } else {
          print(cells(r)(c).getSurfaceState)
        }
      }
      println()
    }
  }

  private def flipCell(cell: Cell): Boolean = {
    if (!cell.isExposed && !cell.isGuess) {
      cell.flip()
      numUnexposedRemaining -= 1
      true
    } else {
      false
    }
  }

  def expandBlank(cell: Cell): Unit = {
    val deltas = Array(
      (-1, -1),
      (-1, 0),
      (-1, 1),
      (0, -1),
      (0, 1),
      (1, -1),
      (1, 0),
      (1, 1)
    )

    val toExplore = Queue[Cell]()
    toExplore.enqueue(cell)

    while (toExplore.nonEmpty) {
      val current = toExplore.dequeue()

      for (delta <- deltas) {
        val r = current.getRow + delta._1
        val c = current.getColumn + delta._2

        if (inBounds(r, c)) {
          val neighbor = cells(r)(c)
          if (flipCell(neighbor) && neighbor.isBlank) {
            toExplore.enqueue(neighbor)
          }
        }
      }
    }
  }

  def playFlip(play: UserPlay): UserPlayResult = {
    val cell = getCellAtLocation(play)
    if (cell == null) {
      return new UserPlayResult(
        false,
        GameState.RUNNING
      ) // Directly use GameState
    }

    if (play.isGuess) {
      val guessResult = cell.toggleGuess()
      return new UserPlayResult(guessResult, GameState.RUNNING)
    }

    val result = flipCell(cell)

    if (cell.isBomb) {
      return new UserPlayResult(result, GameState.LOST)
    }

    if (cell.isBlank) {
      expandBlank(cell)
    }

    if (numUnexposedRemaining == 0) {
      return new UserPlayResult(result, GameState.WON)
    }

    new UserPlayResult(result, GameState.RUNNING)
  }

  def getCellAtLocation(play: UserPlay): Cell = {
    val row = play.row // Using the row variable directly
    val col = play.column // Using the column variable directly
    if (!inBounds(row, col)) {
      null
    } else {
      cells(row)(col)
    }
  }

  def getNumRemaining: Int = numUnexposedRemaining
}
