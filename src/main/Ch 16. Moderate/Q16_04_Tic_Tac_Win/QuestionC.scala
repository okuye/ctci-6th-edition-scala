package Q16_04_Tic_Tac_Win

object QuestionC {

  def hasWinner(p1: Piece, p2: Piece, p3: Piece): Boolean = {
    if (p1 == Piece.Empty) false
    else p1 == p2 && p2 == p3
  }

  def hasWon(board: Array[Array[Piece]]): Piece = {
    for (i <- board.indices) {
      // Check Rows
      if (hasWinner(board(i)(0), board(i)(1), board(i)(2))) {
        return board(i)(0)
      }

      // Check Columns
      if (hasWinner(board(0)(i), board(1)(i), board(2)(i))) {
        return board(0)(i)
      }
    }

    // Check Diagonal
    if (hasWinner(board(0)(0), board(1)(1), board(2)(2))) {
      return board(0)(0)
    }

    if (hasWinner(board(0)(2), board(1)(1), board(2)(0))) {
      return board(0)(2)
    }

    Piece.Empty
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
