package Q1_01_Is_Unique

object QuestionA {
  def isUniqueChars(str: String): Boolean = {
    if (str.length > 128) {
      return false
    }
    val char_set = Array.ofDim[Boolean](128)
    for (i <- 0 until str.length) {
      val value = str.charAt(i).toInt
      if (char_set(value)) return false
      char_set(value) = true
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val words = Array("abcde", "hello", "apple", "kite", "padle")
    for (word <- words) {
      println(s"$word: ${isUniqueChars(word)}")
    }
  }
}
