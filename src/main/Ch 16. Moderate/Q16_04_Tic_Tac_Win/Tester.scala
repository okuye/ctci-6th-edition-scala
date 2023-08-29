package Q16_04_Tic_Tac_Win

object Tester {

  def convertIntToPiece(i: Int): Piece = i match {
    case 1 => Piece.Blue
    case 2 => Piece.Red
    case _ => Piece.Empty
  }

  def hasWonB(board: Array[Array[Piece]]): Piece = {
    for (i <- board.indices; j <- board(0).indices) {
      val winner = QuestionB.hasWon(board, i, j)
      if (winner != Piece.Empty) {
        return winner
      }
    }
    Piece.Empty
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 100) {
      val N = 3
      // Mocking the AssortedMethods.randomMatrix for the conversion
      val board_t = Array.fill(N, N)(scala.util.Random.nextInt(3))
      val board = board_t.map(_.map(convertIntToPiece))

      val winners = Seq(
        hasWonB(board),
        QuestionC.hasWon(board),
        QuestionD.hasWon(board),
        QuestionE.hasWon(board),
        QuestionF.hasWon(board),
        QuestionG.hasWon(board),
        QuestionH.hasWon(board)
      )

      if (winners.distinct.length > 1) {
        println(winners.mkString(" "))
        board_t.foreach(row => println(row.mkString(" ")))
      }
    }

    for (_ <- 0 until 100) {
      val N = 4
      // Mocking the AssortedMethods.randomMatrix for the conversion
      val board_t = Array.fill(N, N)(scala.util.Random.nextInt(3))
      val board = board_t.map(_.map(convertIntToPiece))

      val winners = Seq(
        hasWonB(board),
        QuestionE.hasWon(board),
        QuestionF.hasWon(board),
        QuestionG.hasWon(board),
        QuestionH.hasWon(board)
      )

      if (winners.distinct.length > 1) {
        println(winners.mkString(" "))
        board_t.foreach(row => println(row.mkString(" ")))
      }
    }
  }
}

// Assuming the functions from previous Questions like QuestionB, QuestionC, etc. are defined in their respective objects.
