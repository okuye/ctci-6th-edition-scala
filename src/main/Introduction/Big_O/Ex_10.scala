package Big_O

object Ex_10 {
  def printUnorderedPairs(arrayA: Array[Int], arrayB: Array[Int]): Unit = {
    for (a <- arrayA) {
      for (b <- arrayB) {
        for (_ <- 0 until 1000) {
          println(s"$a,$b")
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arrayA = Array(0, 1, 2, 3)
    val arrayB = Array(4, 5, 6)
    printUnorderedPairs(arrayA, arrayB)
  }
}
