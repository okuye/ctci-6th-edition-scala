package Q1_01_Is_Unique

object QuestionB {

  /* Assumes only letters a through z. */
  def isUniqueChars(str: String): Boolean = {
    if (str.length > 26) { // Only 26 characters
      return false
    }
    var checker = 0
    for (i <- 0 until str.length) {
      val value = str.charAt(i) - 'a'
      if ((checker & (1 << value)) > 0) return false
      checker |= (1 << value)
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
