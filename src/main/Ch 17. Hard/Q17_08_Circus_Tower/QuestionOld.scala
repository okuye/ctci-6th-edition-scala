package Q17_08_Circus_Tower

import scala.collection.mutable.ArrayBuffer

object QuestionOld {

  private def seqWithMaxLength(seq1: ArrayBuffer[HtWt], seq2: ArrayBuffer[HtWt]): ArrayBuffer[HtWt] = {
    if (seq1 == null) {
      seq2
    } else if (seq2 == null) {
      seq1
    } else {
      if (seq1.length > seq2.length) seq1 else seq2
    }
  }

  private def longestIncreasingSubsequence(array: ArrayBuffer[HtWt], solutions: ArrayBuffer[ArrayBuffer[HtWt]], current_index: Int): Unit = {
    if (current_index >= array.length || current_index < 0) {
      return
    }
    val current_element = array(current_index)

    var best_sequence: ArrayBuffer[HtWt] = null
    for (i <- 0 until current_index) {
      if (array(i).isBefore(current_element)) {
        best_sequence = seqWithMaxLength(best_sequence, solutions(i))
      }
    }

    val new_solution = ArrayBuffer.empty[HtWt]
    if (best_sequence != null) {
      new_solution ++= best_sequence
    }
    new_solution.append(current_element)

    solutions.insert(current_index, new_solution)
    longestIncreasingSubsequence(array, solutions, current_index + 1)
  }

  def longestIncreasingSeq(array: ArrayBuffer[HtWt]): ArrayBuffer[HtWt] = {
    array.sortWith(_ < _)

    val solutions = ArrayBuffer.fill(array.length)(ArrayBuffer.empty[HtWt])
    longestIncreasingSubsequence(array, solutions, 0)

    var best_sequence: ArrayBuffer[HtWt] = null
    for (i <- array.indices) {
      best_sequence = seqWithMaxLength(best_sequence, solutions(i))
    }

    best_sequence
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
