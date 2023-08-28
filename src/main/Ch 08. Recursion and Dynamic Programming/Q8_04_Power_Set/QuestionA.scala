package Q8_04_Power_Set

import scala.collection.mutable.ArrayBuffer

object QuestionA {

  def getSubsets(set: ArrayBuffer[Int], index: Int): ArrayBuffer[ArrayBuffer[Int]] = {
    if (set.size == index) {
      // Base case - add empty set
      ArrayBuffer(ArrayBuffer())
    } else {
      val allsubsets = getSubsets(set, index + 1)
      val item = set(index)
      val moresubsets = ArrayBuffer[ArrayBuffer[Int]]()

      for (subset <- allsubsets) {
        val newsubset = subset.clone()
        newsubset += item
        moresubsets += newsubset
      }

      allsubsets ++ moresubsets
    }
  }

  def main(args: Array[String]): Unit = {
    val list = ArrayBuffer(0, 1, 2)
    val subsets = getSubsets(list, 0)
    println(subsets.mkString(", "))
  }
}
