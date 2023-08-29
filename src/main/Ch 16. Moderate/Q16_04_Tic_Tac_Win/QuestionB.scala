package Q16_04_Tic_Tac_Win

object QuestionB {

  def hasWon(board: Array[Array[Piece]], row: Int, column: Int): Piece = {
    if (board.length != board(0).length) return Piece.Empty

    val piece = board(row)(column)

    if (piece == Piece.Empty) return Piece.Empty
    if (hasWonRow(board, row) || hasWonColumn(board, column)) {
      return piece
    }

    if (row == column && hasWonDiagonal(board, 1)) {
      return piece
    }

    if (row == (board.length - column - 1) && hasWonDiagonal(board, -1)) {
      return piece
    }

    Piece.Empty
  }

  def hasWonRow(board: Array[Array[Piece]], row: Int): Boolean = {
    board(row).forall(_ == board(row)(0))
  }

  def hasWonColumn(board: Array[Array[Piece]], column: Int): Boolean = {
    board.forall(_(column) == board(0)(column))
  }

  def hasWonDiagonal(board: Array[Array[Piece]], direction: Int): Boolean = {
    val first = if (direction == 1) board(0)(0) else board(0)(board.length - 1)
    board.indices.forall(i => board(i)(i * direction + (if (direction == -1) board.length - 1 else 0)) == first)
  }

  def main(args: Array[String]): Unit = {
    val N = 3
    // Mocking the AssortedMethods.randomMatrix for the conversion
    val board_t = Array.fill(N, N)(scala.util.Random.nextInt(3))

    board_t(1)(1) = board_t(0)(2)
    board_t(2)(0) = board_t(0)(2)

    val board = board_t.map(row => row.map(Tester.convertIntToPiece))

    val p1 = hasWon(board, 0, 2)

    println(p1)
    board_t.foreach(row => println(row.mkString(" ")))
  }
}

// Mocked Tester object
object Tester {
  def convertIntToPiece(x: Int): Piece = x match {
    case 0 => Piece.Empty
    case 1 => Piece.Red
    case 2 => Piece.Blue
  }
}
