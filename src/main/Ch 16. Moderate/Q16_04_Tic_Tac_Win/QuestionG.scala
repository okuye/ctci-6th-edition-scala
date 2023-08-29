package Q16_04_Tic_Tac_Win

import scala.collection.mutable.ArrayBuffer

object QuestionG {

  class Check(var row: Int, var column: Int, rowI: Int, colI: Int) {
    private val rowIncrement = rowI
    private val columnIncrement = colI

    def increment(): Unit = {
      row += rowIncrement
      column += columnIncrement
    }

    def inBounds(size: Int): Boolean = {
      row >= 0 && column >= 0 && row < size && column < size
    }
  }

  def hasWon(board: Array[Array[Piece]]): Piece = {
    if (board.length != board(0).length) return Piece.Empty
    val size = board.length

    // Create list of things to check
    val instructions = ArrayBuffer[Check]()
    for (i <- 0 until size) {
      instructions += new Check(0, i, 1, 0)
      instructions += new Check(i, 0, 0, 1)
    }
    instructions += new Check(0, 0, 1, 1)
    instructions += new Check(0, size - 1, 1, -1)

    // Check them
    for (instr <- instructions) {
      val winner = hasWon(board, instr)
      if (winner != Piece.Empty) {
        return winner
      }
    }
    Piece.Empty
  }

  def hasWon(board: Array[Array[Piece]], instr: Check): Piece = {
    val first = board(instr.row)(instr.column)
    while (instr.inBounds(board.length)) {
      if (board(instr.row)(instr.column) != first) {
        return Piece.Empty
      }
      instr.increment()
    }
    first
  }

  def main(args: Array[String]): Unit = {
    val N = 3
    // Mocking the AssortedMethods.randomMatrix for the conversion
    val board_t = Array.fill(N, N)(scala.util.Random.nextInt(3))

    val board = board_t.map(row => row.map(Tester.convertIntToPiece))

    val p1 = hasWon(board)

    println(p1)
    board_t.foreach(row => println(row.mkString(" ")))
  }
}

// Mocked Tester object (as before)
object Tester {
  def convertIntToPiece(x: Int): Piece = x match {
    case 0 => Piece.Empty
    case 1 => Piece.Red
    case 2 => Piece.Blue
  }
}
