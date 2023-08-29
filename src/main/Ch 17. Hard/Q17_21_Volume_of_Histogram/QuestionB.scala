package Q17_21_Volume_of_Histogram

object QuestionB {
  def borderedVolume(data: Array[HistogramData], start: Int, end: Int): Int = {
    if (start >= end) return 0

    val min = math.min(data(start).getHeight, data(end).getHeight)
    var sum = 0
    for (i <- start + 1 until end) {
      sum += min - data(i).getHeight
    }
    sum
  }

  def subgraphVolume(histogram: Array[HistogramData], start: Int, end: Int, isLeft: Boolean): Int = {
    if (start >= end) return 0
    var sum = 0
    if (isLeft) {
      val max = histogram(end - 1).getLeftMaxIndex
      sum += borderedVolume(histogram, max, end)
      sum += subgraphVolume(histogram, start, max, isLeft)
    } else {
      val max = histogram(start + 1).getRightMaxIndex
      sum += borderedVolume(histogram, start, max)
      sum += subgraphVolume(histogram, max, end, isLeft)
    }
    sum
  }

  def createHistogramData(histo: Array[Int]): Array[HistogramData] = {
    val histogram = new Array[HistogramData](histo.length)
    for (i <- histo.indices) {
      histogram(i) = HistogramData(histo(i))
    }

    var maxIndex = 0
    for (i <- histo.indices) {
      if (histo(maxIndex) < histo(i)) {
        maxIndex = i
      }
      histogram(i).leftMaxIndex = maxIndex
    }

    maxIndex = histogram.length - 1
    for (i <- histogram.indices.reverse) {
      if (histo(maxIndex) < histo(i)) {
        maxIndex = i
      }
      histogram(i).rightMaxIndex = maxIndex
    }

    histogram
  }

  def computeHistogramVolume(histogram: Array[Int]): Int = {
    val start = 0
    val end = histogram.length - 1

    val data = createHistogramData(histogram)

    val max = data(0).rightMaxIndex

    val leftVolume = subgraphVolume(data, start, max, isLeft = true)
    val rightVolume = subgraphVolume(data, max, end, isLeft = false)

    leftVolume + rightVolume
  }

  def main(args: Array[String]): Unit = {
    val histogram = Array(0, 0, 4, 0, 0, 6, 0, 0, 3, 0, 8, 0, 2, 0, 5, 2, 0, 3, 0, 0)
    val result = computeHistogramVolume(histogram)
    println(result)
  }
}

