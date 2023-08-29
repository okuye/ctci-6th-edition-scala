package Q17_18_Shortest_Supersequence

object QuestionC {

  def shortestSupersequence(big: Array[Int], small: Array[Int]): Option[Range] = {
    val closures = getClosures(big, small)
    getShortestClosure(closures)
  }

  def getClosures(big: Array[Int], small: Array[Int]): Array[Int] = {
    val closure = Array.fill(big.length)(-1)
    for (s <- small) {
      sweepForClosure(big, closure, s)
    }
    closure
  }

  def sweepForClosure(big: Array[Int], closures: Array[Int], value: Int): Unit = {
    var next = -1
    for (i <- big.indices.reverse) {
      if (big(i) == value) {
        next = i
      }
      if ((next == -1 || closures(i) < next) && closures(i) != -1) {
        closures(i) = next
      }
    }
  }

  def getShortestClosure(closures: Array[Int]): Option[Range] = {
    if (closures.isEmpty) return None

    var shortest = Range(0, closures(0))
    for (i <- 1 until closures.length) {
      if (closures(i) == -1) {
        return None
      }
      val range = Range(i, closures(i))
      if (!shortest.shorterThan(range)) {
        shortest = range
      }
    }

    if (shortest.length <= 0) None else Some(shortest)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(9, 2, 4, 6, 2, 5, 9)
    val set = Array(1, 5, 9)

    println(array.length)

    shortestSupersequence(array, set) match {
      case None => println("No valid subsequence.")
      case Some(range) => println(s"${range.start}, ${range.end}")
    }
  }

}
