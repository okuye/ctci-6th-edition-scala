package Big_O

object Ex_08 {
  def printUnorderedPairs(array: Array[Int]): Unit = {
    for (i <- array.indices) {
      for (j <- i until array.length) {
        println(s"${array(i)},${array(j)}")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3)
    printUnorderedPairs(array)
  }
}

