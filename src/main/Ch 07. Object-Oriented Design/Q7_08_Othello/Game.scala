package Q7_08_Othello

class Game private() {
  private val ROWS = 10
  private val COLUMNS = 10
  private val board = new Board(ROWS, COLUMNS)
  private val _players = Array(new Player(Color.Black), new Player(Color.White))

  def getBoard: Board = board

  def players: Array[Player] = _players
}

object Game {
  private var instance: Option[Game] = None

  def getInstance(): Game = {
    if (instance.isEmpty) {
      instance = Some(new Game())
    }
    instance.get
  }

  def initializeAutomator(): Unit = {
    Automator.getInstance().initialize(instance.get.players)
  }
}

//object Game {
//  private var instance: Option[Game] = None
//
//  def getInstance(): Game = {
//    if (instance.isEmpty) {
//      instance = Some(new Game())
//      Automator.getInstance().initialize(instance.get.players)
//    }
//    instance.get
//  }
//}
