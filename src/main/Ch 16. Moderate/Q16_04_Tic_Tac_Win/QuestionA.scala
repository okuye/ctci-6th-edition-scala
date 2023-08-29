package Q16_04_Tic_Tac_Win

object QuestionA {

  def convertBoardToInt(board: Array[Array[Piece]]): Int = {
    var sum = 0
    for {
      row <- board
      piece <- row
    } {
      val value = piece match {
        case Piece.Empty => 0
        case Piece.Red   => 1
        case Piece.Blue  => 2
      }
      sum = sum * 3 + value
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val board: Array[Array[Piece]] = Array(
      Array(Piece.Empty, Piece.Empty, Piece.Empty),
      Array(Piece.Empty, Piece.Empty, Piece.Empty),
      Array(Piece.Blue, Piece.Blue, Piece.Blue)
    )
    val v = convertBoardToInt(board)
    println(v)
  }
}
