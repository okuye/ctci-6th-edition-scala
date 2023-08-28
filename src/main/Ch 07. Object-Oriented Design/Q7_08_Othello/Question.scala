package Q7_08_Othello

object Question extends App {
  val game = Game.getInstance()
  Game.initializeAutomator()
  game.getBoard.initialize()
  game.getBoard.printBoard()
  val automator = Automator.getInstance()

  while (!automator.isOver() && automator.playRandom()) {}

  automator.printScores()
}
