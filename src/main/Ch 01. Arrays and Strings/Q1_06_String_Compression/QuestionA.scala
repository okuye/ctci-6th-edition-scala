package Q1_06_String_Compression

object QuestionA {

  def compressBad(str: String): String = {
    var compressedString = StringBuilder.newBuilder
    var countConsecutive = 0

    for (i <- 0 until str.length) {
      countConsecutive += 1

      if (i + 1 >= str.length || str.charAt(i) != str.charAt(i + 1)) {
        compressedString ++= s"${str.charAt(i)}$countConsecutive"
        countConsecutive = 0
      }
    }

    val result = compressedString.toString()
    if (result.length < str.length) result else str
  }

  def main(args: Array[String]): Unit = {
    val str = "aa"
    println(str)
    println(compressBad(str))
  }

}
