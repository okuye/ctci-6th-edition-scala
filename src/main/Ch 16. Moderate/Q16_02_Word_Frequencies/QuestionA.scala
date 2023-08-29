package Q16_02_Word_Frequencies

object QuestionA {

  def getFrequency(book: Array[String], word: String): Int = {
    val trimmedWord = word.trim().toLowerCase()
    var count = 0
    for (w <- book) {
      if (w.trim().toLowerCase() == trimmedWord) {
        count += 1
      }
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val wordlist = CtCILibrary.AssortedMethods.getLongTextBlobAsStringList()

    val words = Array("the", "Lara", "and", "outcropping", "career", "it")
    for (word <- words) {
      println(s"$word: ${getFrequency(wordlist, word)}")
    }
  }

}
