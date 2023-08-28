package Q1_06_String_Compression

object QuestionC {

  def compress(str: String): String = {
    val finalLength = countCompression(str)
    if (finalLength >= str.length) return str

    val compressed = new StringBuilder(finalLength) // initialize capacity
    var countConsecutive = 0

    for (i <- 0 until str.length) {
      countConsecutive += 1

      if (i + 1 >= str.length || str.charAt(i) != str.charAt(i + 1)) {
        compressed += str.charAt(i)
        compressed ++= countConsecutive.toString
        countConsecutive = 0
      }
    }

    compressed.toString
  }

  def countCompression(str: String): Int = {
    var compressedLength = 0
    var countConsecutive = 0

    for (i <- 0 until str.length) {
      countConsecutive += 1

      if (i + 1 >= str.length || str.charAt(i) != str.charAt(i + 1)) {
        compressedLength += 1 + countConsecutive.toString.length
        countConsecutive = 0
      }
    }

    compressedLength
  }

  def main(args: Array[String]): Unit = {
    val str = "aa"
    println(str)
    println(compress(str))
  }

}
