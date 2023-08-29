package Q17_22_Word_Transformer

import scala.collection.mutable.{ArrayList, HashMap, HashSet, LinkedList}

object QuestionA {
  def wordsOneAway(word: String): ArrayList[String] = {
    val words = new ArrayList[String]()
    for (i <- 0 until word.length) {
      for (c <- 'a' to 'z') {
        val w = word.substring(0, i) + c + word.substring(i + 1)
        words.add(w)
      }
    }
    words
  }

  def transform(visited: HashSet[String], startWord: String, stopWord: String, dictionary: Set[String]): LinkedList[String] = {
    if (startWord == stopWord) {
      val path = new LinkedList[String]()
      path.add(startWord)
      path
    } else if (visited.contains(startWord) || !dictionary.contains(startWord)) {
      null
    } else {
      visited.add(startWord)
      val words = wordsOneAway(startWord)
      for (word <- words) {
        val path = transform(visited, word, stopWord, dictionary)
        if (path != null) {
          path.addFirst(startWord)
          return path
        }
      }
      null
    }
  }

  def transform(start: String, stop: String, words: Array[String]): LinkedList[String] = {
    val dict = setupDictionary(words)
    val visited = new HashSet[String]()
    transform(visited, start, stop, dict)
  }

  def setupDictionary(words: Array[String]): HashSet[String] = {
    val hash = new HashSet[String]()
    for (word <- words) {
      hash.add(word.toLowerCase)
    }
    hash
  }

  def main(args: Array[String]): Unit = {
    val words = Array("maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril")
    val list = transform("tree", "flat", words)

    if (list == null) {
      println("No path.")
    } else {
      println(list.toString)
    }
  }
}

