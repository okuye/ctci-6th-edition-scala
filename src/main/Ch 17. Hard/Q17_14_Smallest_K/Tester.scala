package Q17_14_Smallest_K

import CtCILibrary.AssortedMethods
import scala.util.Random

object Tester {

  def rankB(array: Array[Int], rank: Int): Int = {
    val cloned = array.clone()
    scala.util.Sorting.quickSort(cloned)
    cloned(rank)
  }

  def swap(array: Array[Int], i: Int, j: Int): Unit = {
    val t = array(i)
    array(i) = array(j)
    array(j) = t
  }

  def isUnique(array: Array[Int]): Boolean = {
    val cloned = array.clone()
    scala.util.Sorting.quickSort(cloned)
    !cloned.sliding(2).exists { case Array(a, b) => a == b }
  }

  def max(array: Array[Int], left: Int, right: Int): Int = {
    array.slice(left, right + 1).max
  }

  def randomInt(n: Int): Int = Random.nextInt(n)

  def randomIntInRange(min: Int, max: Int): Int = randomInt(max + 1 - min) + min

  def isEqual(array1: Array[Int], array2: Array[Int]): Boolean = {
    array1 sameElements array2
  }

  def isEquivalent(array1: Array[Int], array2: Array[Int]): Boolean = {
    isEqual(array1.sorted, array2.sorted)
  }

  def testArray(array1: Array[Int]): Boolean = {
    val copy = array1.clone()
    val array2 = Array.fill(array1.length)(0)
    for (i <- array1.indices) {
      array2(i) = QuestionD.rank(array1, i)
    }
    if (!isEqual(array1.sorted, array2)) {
      println("ERROR")
      println("Original Array: " + AssortedMethods.arrayToString(copy))
      println("Ranked Array:   " + AssortedMethods.arrayToString(array2))
      println("Sorted Array:   " + AssortedMethods.arrayToString(array1))
      false
    } else true
  }

  def main(args: Array[String]): Unit = {
    val numberOfTests = 1000
    var countWithC = 0
    var countTotal = 0

    for (_ <- 1 to numberOfTests) {
      val length = AssortedMethods.randomIntInRange(1, 10)
      val rank = AssortedMethods.randomIntInRange(1, length)
      val minRange = -1 * length
      val maxRange = length

      val array = AssortedMethods.randomArray(length, minRange, maxRange)
      val smallestA = QuestionA.smallestK(array.clone(), rank)
      val smallestB = QuestionB.smallestK(array.clone(), rank)
      val smallestD = QuestionD.smallestK(array.clone(), rank)
      var smallestC = smallestD
      if (isUnique(array)) {
        smallestC = QuestionC.smallestK(array.clone(), rank)
        countWithC += 1
      }
      countTotal += 1
      if (
        !isEquivalent(smallestA, smallestB) || !isEquivalent(
          smallestB,
          smallestD
        ) || !isEquivalent(smallestD, smallestC)
      ) {
        println("ERROR")
        println(array.mkString(", "))
        println("ArrayA: " + AssortedMethods.arrayToString(smallestA))
        println("ArrayA: " + AssortedMethods.arrayToString(smallestA))
        println("ArrayB: " + AssortedMethods.arrayToString(smallestB))
        println("ArrayC: " + AssortedMethods.arrayToString(smallestC))
        println("ArrayD: " + AssortedMethods.arrayToString(smallestD))
      }
    }
    println(s"Completed $countTotal runs, including $countWithC with C")
  }

}
