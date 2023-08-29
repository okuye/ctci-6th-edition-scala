package Q17_21_Volume_of_Histogram

object QuestionA {
  def findIndexOfMax(histogram: Array[Int], start: Int, end: Int): Int = {
    var indexOfMax = start
    for (i <- start + 1 to end) {
      if (histogram(i) > histogram(indexOfMax)) {
        indexOfMax = i
      }
    }
    indexOfMax
  }

  def borderedVolume(histogram: Array[Int], start: Int, end: Int): Int = {
    if (start >= end) return 0

    val min = math.min(histogram(start), histogram(end))
    var sum = 0
    for (i <- start + 1 until end) {
      sum += min - histogram(i)
    }
    sum
  }

  def subgraphVolume(histogram: Array[Int], start: Int, end: Int, isLeft: Boolean): Int = {
    if (start >= end) return 0
    var sum = 0
    if (isLeft) {
      val max = findIndexOfMax(histogram, start, end - 1)
      sum += borderedVolume(histogram, max, end)
      sum += subgraphVolume(histogram, start, max, isLeft)
    } else {
      val max = findIndexOfMax(histogram, start + 1, end)
      sum += borderedVolume(histogram, start, max)
      sum += subgraphVolume(histogram, max, end, isLeft)
    }
    sum
  }

  def computeHistogramVolume(histogram: Array[Int]): Int = {
    val start = 0
    val end = histogram.length - 1

    val max = findIndexOfMax(histogram, start, end)

    val leftVolume = subgraphVolume(histogram, start, max, isLeft = true)
    val rightVolume = subgraphVolume(histogram, max, end, isLeft = false)

    leftVolume + rightVolume
  }

  def main(args: Array[String]): Unit = {
    val histogram = Array(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0)
    val result = computeHistogramVolume(histogram)
    println(result)
  }
}
