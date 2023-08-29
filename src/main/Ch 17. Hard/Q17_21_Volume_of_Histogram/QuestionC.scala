package Q17_21_Volume_of_Histogram

object QuestionC {
  def computeHistogramVolume(histo: Array[Int]): Int = {
    val leftMaxes = new Array[Int](histo.length)
    var leftMax = histo(0)
    for (i <- histo.indices) {
      leftMax = math.max(leftMax, histo(i))
      leftMaxes(i) = leftMax
    }

    var sum = 0

    var rightMax = histo(histo.length - 1)
    for (i <- histo.indices.reverse) {
      rightMax = math.max(rightMax, histo(i))
      val secondTallest = math.min(rightMax, leftMaxes(i))

      if (secondTallest > histo(i)) {
        sum += secondTallest - histo(i)
      }
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    val histogram = Array(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0)
    val result = computeHistogramVolume(histogram)
    println(result)
  }
}

