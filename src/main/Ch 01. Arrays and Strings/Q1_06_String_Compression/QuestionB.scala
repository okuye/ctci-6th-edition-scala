package Q1_06_String_Compression

object QuestionB {

  def compress(str: String): String = {
    val compressed = new StringBuilder
    var countConsecutive = 0

    for (i <- 0 until str.length) {
      countConsecutive += 1

      if (i + 1 >= str.length || str.charAt(i) != str.charAt(i + 1)) {
        compressed += str.charAt(i)
        compressed ++= countConsecutive.toString
        countConsecutive = 0
      }
    }

    if (compressed.length < str.length) compressed.toString else str
  }

  def main(args: Array[String]): Unit = {
    val str = "aa"
    println(str)
    println(compress(str))
  }

}
