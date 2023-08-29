package Q17_08_Circus_Tower

import scala.collection.mutable.ArrayBuffer

object QuestionB {

  private def max(seq1: ArrayBuffer[HtWt], seq2: ArrayBuffer[HtWt]): ArrayBuffer[HtWt] = {
    if (seq1 == null) {
      seq2
    } else if (seq2 == null) {
      seq1
    } else {
      if (seq1.length > seq2.length) seq1 else seq2
    }
  }

  private def canAppend(solution: ArrayBuffer[HtWt], value: HtWt): Boolean = {
    if (solution == null) {
      false
    } else if (solution.isEmpty) {
      true
    } else {
      solution.last.isBefore(value)
    }
  }

  def longestIncreasingSeq(array: ArrayBuffer[HtWt]): ArrayBuffer[HtWt] = {
    array.sortWith(_ < _)
    val solutions = ArrayBuffer.fill(array.length)(ArrayBuffer.empty[HtWt])
    var bestSequence: ArrayBuffer[HtWt] = null

    for (i <- array.indices) {
      val longestAtIndex = bestSeqAtIndex(array, solutions, i)
      solutions(i) = longestAtIndex
      bestSequence = max(bestSequence, longestAtIndex)
    }

    bestSequence
  }

  private def bestSeqAtIndex(array: ArrayBuffer[HtWt], solutions: ArrayBuffer[ArrayBuffer[HtWt]], index: Int): ArrayBuffer[HtWt] = {
    val value = array(index)

    var bestSequence = ArrayBuffer.empty[HtWt]

    for (i <- 0 until index) {
      val solution = solutions(i)
      if (canAppend(solution, value)) {
        bestSequence = max(solution, bestSequence)
      }
    }

    val best = bestSequence.clone()
    best.append(value)

    best
  }

  def initialize(): ArrayBuffer[HtWt] = {
    ArrayBuffer(
      HtWt(65, 60),
      HtWt(70, 150),
      HtWt(56, 90),
      HtWt(75, 190),
      HtWt(60, 95),
      HtWt(68, 110),
      HtWt(35, 65),
      HtWt(40, 60),
      HtWt(45, 63)
    )
  }

  def printList(list: ArrayBuffer[HtWt]): Unit = {
    list.foreach(item => println(item.toString + " "))
  }

  def main(args: Array[String]): Unit = {
    val items = initialize()
    val solution = longestIncreasingSeq(items)
    printList(solution)
  }
}
