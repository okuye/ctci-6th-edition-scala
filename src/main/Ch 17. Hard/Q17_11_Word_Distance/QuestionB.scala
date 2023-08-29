package Q17_11_Word_Distance

import scala.collection.mutable.HashMap
import CtCILibrary.AssortedMethods
import CtCILibrary.HashMapList

object QuestionB {

  def getWordLocations(words: Array[String]): HashMap[String, List[Int]] = {
    val locations = new HashMap[String, List[Int]]()
    for (i <- words.indices) {
      locations(words(i)) = i :: locations.getOrElse(words(i), Nil)
    }
    locations
  }

  def findMinDistancePair(array1: List[Int], array2: List[Int]): LocationPair = {
    if (array1.isEmpty || array2.isEmpty) return null

    var index1 = 0
    var index2 = 0
    var best = new LocationPair(array1.head, array2.head)
    var current = new LocationPair(array1.head, array2.head)

    while (index1 < array1.length && index2 < array2.length) {
      current.setLocations(array1(index1), array2(index2))
      best.updateWithMin(current)
      if (current.location1 < current.location2) {
        index1 += 1
      } else {
        index2 += 1
      }
    }

    best
  }

  def findClosest(word1: String, word2: String, locations: HashMap[String, List[Int]]): LocationPair = {
    findMinDistancePair(locations(word1), locations(word2))
  }

  def main(args: Array[String]): Unit = {
    val wordlist = AssortedMethods.getLongTextBlobAsStringList
    val word1 = "river"
    val word2 = "life"
    val locations = getWordLocations(wordlist.toArray)
    val pair = findClosest(word1, word2, locations)
    println(s"Distance between <$word1> and <$word2>: ${pair.toString}")
  }
}
