package Q16_04_Tic_Tac_Win

object QuestionE {

  def hasWon(board: Array[Array[Piece]]): Piece = {
    val size = board.length
    if (board(0).length != size) return Piece.Empty
    var first: Piece = Piece.Empty

    // Check rows
    for (i <- 0 until size) {
      first = board(i)(0)
      if (first != Piece.Empty) {
        if (board(i).forall(_ == first)) {
          return first
        }
      }
    }

    // Check columns
    for (i <- 0 until size) {
      first = board(0)(i)
      if (first != Piece.Empty) {
        if ((0 until size).forall(j => board(j)(i) == first)) {
          return first
        }
      }
    }

    // Check diagonals
    first = board(0)(0)
    if (first != Piece.Empty) {
      if ((0 until size).forall(i => board(i)(i) == first)) {
        return first
      }
    }

    first = board(0)(size - 1)
    if (first != Piece.Empty) {
      if ((0 until size).forall(i => board(i)(size - i - 1) == first)) {
        return first
      }
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
