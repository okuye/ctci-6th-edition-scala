package Big_O

object Q_11 {
  val numChars: Int = 26

  def printSortedStrings(remaining: Int): Unit = {
    printSortedStrings(remaining, "")
  }

  def printSortedStrings(remaining: Int, prefix: String): Unit = {
    if (remaining == 0) {
      println(prefix)
    } else {
      for (i <- 0 until numChars) {
        val c: Char = ithLetter(i)
        printSortedStrings(remaining - 1, prefix + c)
      }
    }
  }

  def isInOrder(s: String): Boolean = {
    for (i <- 1 until s.length) {
      val prev: Int = ithLetter(s.charAt(i - 1))
      val curr: Int = ithLetter(s.charAt(i))
      if (prev > curr) {
        return false
      }
    }
    true
  }

  def ithLetter(i: Int): Char = {
    ('a' + i).toChar
  }

  def main(args: Array[String]): Unit = {
    printSortedStrings(3)
  }
}
