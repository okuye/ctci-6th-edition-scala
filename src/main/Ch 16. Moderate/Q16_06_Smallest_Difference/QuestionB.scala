package Q16_06_Smallest_Difference

object QuestionB {

  def findSmallestDifference(arrayA: Array[Int], arrayB: Array[Int]): Int = {
    if (arrayA.isEmpty || arrayB.isEmpty) return -1

    val sortedA = arrayA.sorted
    val sortedB = arrayB.sorted

    var indexA = 0
    var indexB = 0
    var smallestDifference = Int.MaxValue

    while (indexA < sortedA.length && indexB < sortedB.length) {
      val difference = Math.abs(sortedA(indexA) - sortedB(indexB))
      smallestDifference = Math.min(smallestDifference, difference)

      if (sortedA(indexA) < sortedB(indexB)) {
        indexA += 1
      } else {
        indexB += 1
      }
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
