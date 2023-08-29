package Q16_06_Smallest_Difference

object QuestionC {

  def getClosestValue(array: Array[Int], target: Int): Int = {
    var low = 0
    var high = array.length - 1
    var mid = 0

    while (low <= high) {
      mid = low + (high - low) / 2
      if (array(mid) < target) {
        low = mid + 1
      } else if (array(mid) > target) {
        high = mid - 1
      } else {
        return array(mid)
      }
    }

    val valueA = if (low < 0 || low >= array.length) Int.MaxValue else array(low)
    val valueB = if (high < 0 || high >= array.length) Int.MaxValue else array(high)

    if (Math.abs(valueA - target) < Math.abs(valueB - target)) valueA else valueB // return closest value
  }

  def findSmallestDifference(shorter: Array[Int], longer: Array[Int]): Int = {
    if (shorter.isEmpty || longer.isEmpty) return -1
    if (shorter.length > longer.length) return findSmallestDifference(longer, shorter)

    val sortedShorter = shorter.sorted

    var smallestDifference = Int.MaxValue
    for (target <- longer) {
      val closest = getClosestValue(sortedShorter, target)
      smallestDifference = Math.min(smallestDifference, Math.abs(closest - target))
    }

    smallestDifference
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(1, 3, 15, 11, 2)
    val array2 = Array(23, 127, 234, 19, 8)
    val difference = findSmallestDifference(array1, array2)
    println(difference)
  }
}
