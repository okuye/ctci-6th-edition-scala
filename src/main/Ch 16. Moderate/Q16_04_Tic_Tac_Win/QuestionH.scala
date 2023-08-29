package Q16_04_Tic_Tac_Win

import scala.collection.mutable.ArrayBuffer

case class Position(row: Int, column: Int)

object QuestionH {

  def hasWon(board: Array[Array[Piece]]): Piece = {
    if (board.length != board(0).length) return Piece.Empty
    val size = board.length

    val instructions = ArrayBuffer[PositionIterator]()
    for (i <- 0 until size) {
      instructions += new PositionIterator(Position(0, i), 1, 0, size)
      instructions += new PositionIterator(Position(i, 0), 0, 1, size)
    }
    instructions += new PositionIterator(Position(0, 0), 1, 1, size)
    instructions += new PositionIterator(Position(0, size - 1), 1, -1, size)

    for (iterator <- instructions) {
      val winner = hasWon(board, iterator)
      if (winner != Piece.Empty) {
        return winner
      }
    }
    Piece.Empty
  }

  def hasWon(board: Array[Array[Piece]], iterator: PositionIterator): Piece = {
    val firstPosition = iterator.next()
    val first = board(firstPosition.row)(firstPosition.column)
    while (iterator.hasNext) {
      val position = iterator.next()
      if (board(position.row)(position.column) != first) {
        return Piece.Empty
      }
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
