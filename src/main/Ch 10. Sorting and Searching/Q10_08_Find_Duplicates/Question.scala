package Q10_08_Find_Duplicates

import CtCILibrary.AssortedMethods

object Question {

  def checkDuplicates(array: Array[Int]): Unit = {
    val bs = new BitSet(32000)
    for (num <- array) {
      val num0 = num - 1 // bitset starts at 0, numbers start at 1
      if (bs.get(num0)) {
        println(num)
      } else {
        bs.set(num0)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val array = AssortedMethods.randomArray(30, 1, 30)
    println(AssortedMethods.arrayToString(array))
    checkDuplicates(array)
  }
}
