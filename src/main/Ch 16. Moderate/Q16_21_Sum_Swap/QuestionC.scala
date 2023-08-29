package Q16_21_Sum_Swap

import scala.collection.mutable.HashSet

object QuestionC {

  def sum(array: Array[Int]): Int = array.sum

  def findSwapValues(array1: Array[Int], array2: Array[Int]): Option[(Int, Int)] = {
    val target = getTarget(array1, array2)
    target.flatMap(t => findDifference(array1, array2, t))
  }

  def findDifference(array1: Array[Int], array2: Array[Int], target: Int): Option[(Int, Int)] = {
    val contents2 = getContents(array2)
    array1.collectFirst {
      case one if contents2.contains(one - target) => (one, one - target)
    }
  }

  def getTarget(array1: Array[Int], array2: Array[Int]): Option[Int] = {
    val sum1 = array1.sum
    val sum2 = array2.sum

    if ((sum1 - sum2) % 2 != 0) None
    else Some((sum1 - sum2) / 2)
  }

  def getContents(array: Array[Int]): HashSet[Int] = {
    val set = new HashSet[Int]()
    array.foreach(set.add)
    set
  }

  def main(args: Array[String]): Unit = {
    val array1 = Array(-9, -1, -4, 8, 9, 6, -5, -7, 3, 9)
    val array2 = Array(6, 6, 4, -1, 7, -6, -9, 4, -8, 8)
    val swaps = findSwapValues(array1, array2)
    swaps match {
      case Some((one, two)) => println(s"$one $two")
      case None => println("null")
    }
  }
}
