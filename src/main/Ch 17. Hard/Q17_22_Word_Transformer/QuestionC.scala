package Q17_22_Word_Transformer

import scala.collection.mutable.{ArrayList, HashMap, HashSet, LinkedList}

object QuestionC {
  def transform(startWord: String, stopWord: String, words: Array[String]): LinkedList[String] = {
    val wildcardToWordList: HashMap[String, ArrayList[String]] = getWildcardToWordList(words)

    val sourceData: BFSData = new BFSData(startWord)
    val destData: BFSData = new BFSData(stopWord)

    while (!sourceData.isFinished && !destData.isFinished) {
      val collision: String = searchLevel(wildcardToWordList, sourceData, destData)
      if (collision != null) {
        return mergePaths(sourceData, destData, collision)
      }

      val collision2: String = searchLevel(wildcardToWordList, destData, sourceData)
      if (collision2 != null) {
        return mergePaths(sourceData, destData, collision2)
      }
    }

    null
  }

  def searchLevel(wildcardToWordList: HashMap[String, ArrayList[String]], primary: BFSData, secondary: BFSData): String = {
    val count: Int = primary.toVisit.size
    for (_ <- 0 until count) {
      val pathNode: PathNode = primary.toVisit.poll
      val word: String = pathNode.getWord

      if (secondary.visited.contains(word)) {
        return pathNode.getWord
      }

      val words: ArrayList[String] = getValidLinkedWords(word, wildcardToWordList)
      for (w <- words) {
        if (!primary.visited.contains(w)) {
          val next: PathNode = new PathNode(w, pathNode)
          primary.visited.put(w, next)
          primary.toVisit.add(next)
        }
      }
    }
    null
  }

  def mergePaths(bfs1: BFSData, bfs2: BFSData, connection: String): LinkedList[String] = {
    val end1: PathNode = bfs1.visited.get(connection)
    val end2: PathNode = bfs2.visited.get(connection)
    val pathOne: LinkedList[String] = end1.collapse(false)
    val pathTwo: LinkedList[String] = end2.collapse(true)
    pathTwo.removeFirst()
    pathOne.addAll(pathTwo)
    pathOne
  }

  def getWildcardRoots(word: String): ArrayList[String] = {
    val words: ArrayList[String] = new ArrayList[String]()
    for (i <- 0 until word.length) {
      val w: String = word.substring(0, i) + "_" + word.substring(i + 1)
      words.add(w)
    }
    words
  }

  def getWildcardToWordList(words: Array[String]): HashMap[String, ArrayList[String]] = {
    val wildcardToWords: HashMap[String, ArrayList[String]] = new HashMap[String, ArrayList[String]]()
    for (word <- words) {
      val linked: ArrayList[String] = getWildcardRoots(word)
      for (linkedWord <- linked) {
        wildcardToWords.getOrElseUpdate(linkedWord, new ArrayList[String]()).add(word)
      }
    }
    wildcardToWords
  }

  def getValidLinkedWords(word: String, wildcardToWords: HashMap[String, ArrayList[String]]): ArrayList[String] = {
    val wildcards: ArrayList[String] = getWildcardRoots(word)
    val linkedWords: ArrayList[String] = new ArrayList[String]()
    for (wildcard <- wildcards) {
      val words: ArrayList[String] = wildcardToWords.getOrElse(wildcard, new ArrayList[String]())
      for (linkedWord <- words) {
        if (linkedWord != word) {
          linkedWords.add(linkedWord)
        }
      }
    }
    linkedWords
  }

  def main(args: Array[String]): Unit = {
    val words: Array[String] = Array("maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril")
    val list: LinkedList[String] = transform("tree", "flat", words)

    if (list == null) {
      println("No path.")
    } else {
      println(list.toString)
    }
  }
}
