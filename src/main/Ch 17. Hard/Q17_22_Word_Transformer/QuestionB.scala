package Q17_22_Word_Transformer

import scala.collection.mutable.{ArrayList, HashMap, HashSet, LinkedList}

object QuestionB {
  def transform(start: String, stop: String, words: Array[String]): LinkedList[String] = {
    val wildcardToWordList: HashMap[String, ArrayList[String]] = createWildcardToWordMap(words)
    val visited: HashSet[String] = new HashSet[String]()
    transform(visited, start, stop, wildcardToWordList)
  }

  def transform(visited: HashSet[String], start: String, stop: String, wildcardToWordList: HashMap[String, ArrayList[String]]): LinkedList[String] = {
    if (start == stop) {
      val path: LinkedList[String] = new LinkedList[String]()
      path.add(start)
      path
    } else if (visited.contains(start)) {
      null
    } else {
      visited.add(start)
      val words: ArrayList[String] = getValidLinkedWords(start, wildcardToWordList)
      for (word <- words) {
        val path: LinkedList[String] = transform(visited, word, stop, wildcardToWordList)
        if (path != null) {
          path.addFirst(start)
          return path
        }
      }
      null
    }
  }

  def createWildcardToWordMap(words: Array[String]): HashMap[String, ArrayList[String]] = {
    val wildcardToWords: HashMap[String, ArrayList[String]] = new HashMap[String, ArrayList[String]]()
    for (word <- words) {
      val linked: ArrayList[String] = getWildcardRoots(word)
      for (linkedWord <- linked) {
        wildcardToWords.getOrElseUpdate(linkedWord, new ArrayList[String]()).add(word)
      }
    }
    wildcardToWords
  }

  def getWildcardRoots(w: String): ArrayList[String] = {
    val words: ArrayList[String] = new ArrayList[String]()
    for (i <- 0 until w.length) {
      val word: String = w.substring(0, i) + "_" + w.substring(i + 1)
      words.add(word)
    }
    words
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

