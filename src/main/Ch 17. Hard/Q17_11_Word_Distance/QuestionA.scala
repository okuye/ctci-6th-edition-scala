package Q17_11_Word_Distance

import CtCILibrary.AssortedMethods

object QuestionA {

  def findClosest(words: Array[String], word1: String, word2: String): LocationPair = {
    var best = new LocationPair(-1, -1)
    var current = new LocationPair(-1, -1)

    for (i <- words.indices) {
      val word = words(i)
      if (word == word1) {
        current.location1 = i
        best.updateWithMin(current)
      } else if (word == word2) {
        current.location2 = i
        best.updateWithMin(current)
      }
    }

    best
  }

  def main(args: Array[String]): Unit = {
    val wordlist = AssortedMethods.getLongTextBlobAsStringList
    val word1 = "river"
    val word2 = "life"
    val pair = findClosest(wordlist, word1, word2)
    println(s"Distance between <$word1> and <$word2>: ${pair.toString}")
  }
}
