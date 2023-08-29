package Q17_11_Word_Distance

import CtCILibrary.AssortedMethods

object Tester {

  def wordAtLocation(words: Array[String], loc: Int): Option[String] = {
    if (loc < 0 || loc >= words.length) None
    else Some(words(loc))
  }

  def searchConfirm(words: Array[String], word1: String, word2: String, distance: Int): Boolean = {
    var foundAtDistance = false
    for (i <- words.indices) {
      if (words(i) == word1) {
        for (j <- 1 until distance) {
          (wordAtLocation(words, i - j), wordAtLocation(words, i + j)) match {
            case (Some(w1), _) if w1 == word2 => return false
            case (_, Some(w2)) if w2 == word2 => return false
            case _ =>
          }
        }

        (wordAtLocation(words, i - distance), wordAtLocation(words, i + distance)) match {
          case (Some(w1), _) if w1 == word2 => foundAtDistance = true
          case (_, Some(w2)) if w2 == word2 => foundAtDistance = true
          case _ =>
        }
      }
    }
    foundAtDistance
  }

  def main(args: Array[String]): Unit = {
    val wordlist = AssortedMethods.getLongTextBlobAsStringList
    println(AssortedMethods.stringArrayToString(wordlist))
    val locations = QuestionB.getWordLocations(wordlist)

    val pairs = Array(("Lara", "the"), ("river", "life"), ("path", "their"), ("life", "a"))
    for ((word1, word2) <- pairs) {
      val pairA = QuestionA.findClosest(wordlist, word1, word2)
      val pairB = QuestionB.findClosest(word1, word2, locations)
      val confirmC = searchConfirm(wordlist, word1, word2, pairA.distance())

      println(s"Distance between <$word1> and <$word2>: $confirmC")
      println(s"${pairA.toString}: ${pairA.distance()}")
      println(s"${pairB.toString}: ${pairB.distance()}")
      println()
    }
  }
}
