package Q16_21_Sum_Swap

object QuestionD {

  def sum(array: Array[Int]): Int = array.sum

  def getTarget(array1: Array[Int], array2: Array[Int]): Option[Int] = {
    val sum1 = array1.sum
    val sum2 = array2.sum

    if ((sum1 - sum2) % 2 != 0) None
    else Some((sum1 - sum2) / 2)
  }

  def findSwapValues(array1: Array[Int], array2: Array[Int]): Option[(Int, Int)] = {
    val target = getTarget(array1, array2)
    target.flatMap(t => findDifference(array1, array2, t))
  }

  def findDifference(array1: Array[Int], array2: Array[Int], target: Int): Option[(Int, Int)] = {
    val sortedArray1 = array1.sorted
    val sortedArray2 = array2.sorted

    var a = 0
    var b = 0

    while (a < sortedArray1.length && b < sortedArray2.length) {
      val difference = sortedArray1(a) - sortedArray2(b)
      if (difference == target) {
        return Some((sortedArray1(a), sortedArray2(b)))
      } else if (difference < target) {
        a += 1
      } else {
        b += 1
      }
    }

    None
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(1, 1, 1, 2, 2, 4)
    val array2 = Array(3, 3, 3, 6)
    val swaps = findSwapValues(array1, array2)
    swaps match {
      case Some((one, two)) => println(s"$one $two")
      case None => println("null")
    }
  }
}
