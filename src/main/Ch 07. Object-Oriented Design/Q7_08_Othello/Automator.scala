package Q7_08_Othello

import scala.collection.mutable.ArrayBuffer

object Automator {
  private var instance: Automator = _
  def getInstance(): Automator = {
    if (instance == null) {
      instance = new Automator()
    }
    instance
  }
}

class Automator private () {
  private var players: Array[Player] = _
  private var lastPlayer: Player = _
  val remainingMoves: ArrayBuffer[Location] = ArrayBuffer((for {
    r <- 0 until 10
    c <- 0 until 10
  } yield new Location(r, c)): _*)

  def initialize(ps: Array[Player]): Unit = {
    players = ps
    lastPlayer = players(1)
  }

  def shuffle(): Unit = {
    scala.util.Random.shuffle(remainingMoves)
  }

  def removeLocation(r: Int, c: Int): Unit = {
    remainingMoves --= remainingMoves.filter(_.isSameAs(r, c))
  }

  def getLocation(index: Int): Location = {
    remainingMoves(index)
  }

  def playRandom(): Boolean = {
    val board = Game.getInstance().getBoard
    shuffle()
    lastPlayer = if (lastPlayer == players(0)) players(1) else players(0)
    val color = lastPlayer.getColor.toString

    for (loc <- remainingMoves) {
      val success = lastPlayer.playPiece(loc.getRow, loc.getColumn)

      if (success) {
        println(s"Success: $color move at (${loc.getRow}, ${loc.getColumn})")
        board.printBoard()
        printScores()
        return true
      }
    }
    println(s"Game over. No moves found for $color")
    false
  }

  def isOver(): Boolean = {
    players(0).getScore == 0 || players(1).getScore == 0
  }

  def printScores(): Unit = {
    println(s"Score: ${players(0).getColor.toString}: ${players(
      0
    ).getScore}, ${players(1).getColor.toString}: ${players(1).getScore}")
  }
}
