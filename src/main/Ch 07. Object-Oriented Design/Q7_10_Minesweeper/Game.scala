package Q7_10_Minesweeper

import Q7_09_Minesweeper.Board

import scala.io.StdIn

object GameState extends Enumeration {
  val WON, LOST, RUNNING = Value
}

class Game(r: Int, c: Int, b: Int) {
  private var board: Option[Board] = None
  private val rows: Int = r
  private val columns: Int = c
  private val bombs: Int = b
  private var state: GameState.Value = GameState.RUNNING

  def initialize(): Boolean = {
    if (board.isEmpty) {
      board = Some(new Board(rows, columns, bombs))
      board.get.printBoard(true)
      true
    } else {
      println("Game has already been initialized.")
      false
    }
  }

  def start(): Boolean = {
    if (board.isEmpty) {
      initialize()
    }
    playGame()
  }

  def printGameState(): Unit = {
    state match {
      case GameState.LOST =>
        board.get.printBoard(true)
        println("FAIL")
      case GameState.WON =>
        board.get.printBoard(true)
        println("WIN")
      case GameState.RUNNING =>
        println(s"Number remaining: ${board.get.getNumRemaining}")
        board.get.printBoard(false)
    }
  }

  private def playGame(): Boolean = {
    printGameState()

    while (state == GameState.RUNNING) {
      val input = StdIn.readLine()
      if (input == "exit") {
        return false
      }

      val play = UserPlay.fromString(input)
      if (play.isDefined) {
        val result = board.get.playFlip(play.get)
        if (result.successfulMove()) {
          state = result.getResultingState() // Assuming getResultingState is defined in UserPlayResult
        } else {
          println(s"Could not flip cell (${play.get.row},${play.get.column}).") // Using row and column directly
        }
        printGameState()
      }
    }
    true
  }
}
