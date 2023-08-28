package Q7_01_Deck_of_Cards

object Question {

  def main(args: Array[String]): Unit = {
    val numHands = 5

    val automator = new BlackJackGameAutomator(numHands)
    automator.initializeDeck()
    val success = automator.dealInitial()

    if (!success) {
      println("Error. Out of cards.")
    } else {
      println("-- Initial --")
      automator.printHandsAndScore()
      val blackjacks = automator.getBlackJacks()
      if (blackjacks.nonEmpty) {
        print("Blackjack at ")
        blackjacks.foreach(i => print(s"$i, "))
        println()
      } else {
        val successPlayAll = automator.playAllHands()
        if (!successPlayAll) {
          println("Error. Out of cards.")
        } else {
          println("\n-- Completed Game --")
          automator.printHandsAndScore()
          val winners = automator.getWinners()
          if (winners.nonEmpty) {
            print("Winners: ")
            winners.foreach(i => print(s"$i, "))
            println()
          } else {
            println("Draw. All players have busted.")
          }
        }
      }
    }
  }
}
