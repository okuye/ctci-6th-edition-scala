package Q1_01_Is_Unique

object Tester {

  def main(args: Array[String]): Unit = {
    val words = Array("abcde", "hello", "apple", "kite", "padle")
    for (word <- words) {
      val wordA = QuestionA.isUniqueChars(word)
      val wordB = QuestionB.isUniqueChars(word)
      if (wordA == wordB) {
        println(s"$word: $wordA")
      } else {
        println(s"$word: $wordA vs $wordB")
      }
    }
  }
}
