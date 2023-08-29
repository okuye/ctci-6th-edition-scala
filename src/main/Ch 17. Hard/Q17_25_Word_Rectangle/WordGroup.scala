package Q17_25_Word_Rectangle

import scala.collection.mutable.{HashMap, ArrayBuffer}

class WordGroup {
  private val lookup = HashMap[String, Boolean]()
  private val group = ArrayBuffer[String]()

  def containsWord(s: String): Boolean = lookup.contains(s)

  def addWord(s: String): Unit = {
    group += s
    lookup(s) = true
  }

  def length(): Int = group.size

  def getWord(i: Int): String = group(i)

  def getWords(): ArrayBuffer[String] = group
}

object WordGroup {
  def createWordGroups(list: Array[String]): Array[WordGroup] = {
    var groupList: Array[WordGroup] = Array.empty
    var maxWordLength = 0

    // Find out the length of the longest word
    for (i <- 0 until list.length) {
      if (list(i).length > maxWordLength) {
        maxWordLength = list(i).length
      }
    }

    /* Group the words in the dictionary into lists of words of
     * same length. groupList(i) will contain a list of words, each
     * of length (i+1). */
    groupList = new Array[WordGroup](maxWordLength)
    for (i <- 0 until list.length) {
      // We do wordLength - 1 instead of just wordLength since this is used as an index and no words are of length 0
      val wordLength = list(i).length - 1
      if (groupList(wordLength) == null) {
        groupList(wordLength) = new WordGroup
      }
      groupList(wordLength).addWord(list(i))
    }
    groupList
  }
}
