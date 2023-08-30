package Big_O

object Ex_07 {
  def printPairs(array: Array[Int]): Unit = {
    for (i <- array.indices) {
      for (j <- array.indices) {
        println(s"${array(i)},${array(j)}")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3)
    printPairs(array)
  }
}
