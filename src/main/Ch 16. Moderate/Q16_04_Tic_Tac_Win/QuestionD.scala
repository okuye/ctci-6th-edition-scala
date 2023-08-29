package Q16_04_Tic_Tac_Win

object QuestionD {

  def hasWinner(p1: Piece, p2: Piece, p3: Piece): Boolean = {
    if (p1 == Piece.Empty) false
    else p1 == p2 && p2 == p3
  }

  def hasWon(board: Array[Array[Piece]]): Piece = {
    if (board(0)(0) != Piece.Empty &&
      (hasWinner(board(0)(0), board(0)(1), board(0)(2)) ||
        hasWinner(board(0)(0), board(1)(0), board(2)(0)))) {
      board(0)(0)
    } else if (board(2)(2) != Piece.Empty &&
      (hasWinner(board(2)(0), board(2)(1), board(2)(2)) ||
        hasWinner(board(0)(2), board(1)(2), board(2)(2)))) {
      board(2)(2)
    } else if (board(1)(1) != Piece.Empty &&
      (hasWinner(board(0)(0), board(1)(1), board(2)(2)) ||
        hasWinner(board(0)(2), board(1)(1), board(2)(0)) ||
        hasWinner(board(1)(0), board(1)(1), board(1)(2)) ||
        hasWinner(board(0)(1), board(1)(1), board(2)(1)))) {
      board(1)(1)
    } else {
      Piece.Empty
    }
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
