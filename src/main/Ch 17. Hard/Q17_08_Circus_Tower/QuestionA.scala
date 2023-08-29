package Q17_08_Circus_Tower

import scala.collection.mutable.ArrayBuffer

object QuestionA {
  def longestIncreasingSeq(items: ArrayBuffer[HtWt]): ArrayBuffer[HtWt] = {
    items.sortWith(_ < _)
    bestSeqAtIndex(items, ArrayBuffer.empty[HtWt], 0)
  }

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
    if (solution.isEmpty) {
      true
    } else {
      solution.last.isBefore(value)
    }
  }

  private def bestSeqAtIndex(array: ArrayBuffer[HtWt], sequence: ArrayBuffer[HtWt], index: Int): ArrayBuffer[HtWt] = {
    if (index >= array.length) return sequence

    val value = array(index)

    var bestWith: ArrayBuffer[HtWt] = null
    if (canAppend(sequence, value)) {
      val sequenceWith = sequence.clone()
      sequenceWith.append(value)
      bestWith = bestSeqAtIndex(array, sequenceWith, index + 1)
    }

    val bestWithout = bestSeqAtIndex(array, sequence, index + 1)
    max(bestWith, bestWithout)
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
