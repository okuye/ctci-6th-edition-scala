package Q16_21_Sum_Swap

object QuestionA {

  def sum(array: Array[Int]): Int = array.sum

  def findSwapValues(array1: Array[Int], array2: Array[Int]): Option[(Int, Int)] = {
    val sum1 = sum(array1)
    val sum2 = sum(array2)

    for {
      one <- array1
      two <- array2
      newSum1 = sum1 - one + two
      newSum2 = sum2 - two + one
      if newSum1 == newSum2
    } yield (one, two)
  }.headOption

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
