package Q16_04_Tic_Tac_Win

object QuestionF {

  def hasWon(board: Array[Array[Piece]]): Piece = {
    var winner: Piece = Piece.Empty

    // Check rows
    for (i <- board.indices) {
      winner = hasWon(board, i, 0, 1, 0)
      if (winner != Piece.Empty) {
        return winner
      }
    }

    // Check columns
    for (i <- board(0).indices) {
      winner = hasWon(board, 0, i, 0, 1)
      if (winner != Piece.Empty) {
        return winner
      }
    }

    // Check top/left -> bottom/right diagonal
    winner = hasWon(board, 0, 0, 1, 1)
    if (winner != Piece.Empty) {
      return winner
    }

    // Check top/right -> bottom/left diagonal
    hasWon(board, 0, board(0).length - 1, 1, -1)
  }

  def hasWon(board: Array[Array[Piece]], row: Int, col: Int, incrementRow: Int, incrementCol: Int): Piece = {
    val first = board(row)(col)
    var r = row
    var c = col
    while (r < board.length && c >= 0 && c < board(r).length) {
      if (board(r)(c) != first) {
        return Piece.Empty
      }
      r += incrementRow
      c += incrementCol
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
