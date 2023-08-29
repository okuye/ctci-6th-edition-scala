package Q16_02_Word_Frequencies

import java.util.HashMap

object QuestionB {

  def setupDictionary(book: Array[String]): HashMap[String, Int] = {
    val table = new HashMap[String, Int]()
    for (word <- book) {
      val lowercaseWord = word.toLowerCase().trim()
      if (lowercaseWord != "") {
        if (!table.containsKey(lowercaseWord)) {
          table.put(lowercaseWord, 0)
        }
        table.put(lowercaseWord, table.get(lowercaseWord) + 1)
      }
    }
    table
  }

  def getFrequency(table: HashMap[String, Int], word: String): Int = {
    if (table == null || word == null) {
      -1
    } else {
      val lowercaseWord = word.toLowerCase()
      if (table.containsKey(lowercaseWord)) {
        table.get(lowercaseWord)
      } else {
        0
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val wordlist = CtCILibrary.AssortedMethods.getLongTextBlobAsStringList()
    val dictionary = setupDictionary(wordlist)

    val words = Array("the", "Lara", "and", "outcropping", "career", "it")
    for (word <- words) {
      println(s"$word: ${getFrequency(dictionary, word)}")
    }
  }

}
