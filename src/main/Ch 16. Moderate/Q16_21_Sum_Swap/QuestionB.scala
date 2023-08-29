package Q16_21_Sum_Swap

object QuestionB {

  def findSwapValues(array1: Array[Int], array2: Array[Int]): Option[(Int, Int)] = {
    val target = getTarget(array1, array2)

    for {
      t <- target
      one <- array1
      two <- array2
      if one - two == t
    } return Some((one, two))

    None
  }


  def getTarget(array1: Array[Int], array2: Array[Int]): Option[Int] = {
    val sum1 = array1.sum
    val sum2 = array2.sum

    if ((sum1 - sum2) % 2 != 0) None
    else Some((sum1 - sum2) / 2)
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
