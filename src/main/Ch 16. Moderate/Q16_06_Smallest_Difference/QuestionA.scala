package Q16_06_Smallest_Difference

object QuestionA {

  def findSmallestDifference(arrayA: Array[Int], arrayB: Array[Int]): Int = {
    if (arrayA.isEmpty || arrayB.isEmpty) return -1

    var smallestDifference = Int.MaxValue
    for {
      a <- arrayA
      b <- arrayB
    } {
      smallestDifference = Math.min(smallestDifference, Math.abs(a - b))
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
