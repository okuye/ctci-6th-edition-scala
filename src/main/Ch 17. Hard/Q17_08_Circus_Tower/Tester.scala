package Q17_08_Circus_Tower

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object Tester {

  def randomInt(n: Int): Int = {
    Random.nextInt(n)
  }

  def validate(seq: ArrayBuffer[HtWt]): Boolean = {
    for (i <- 1 until seq.size) {
      val prev = seq(i - 1)
      val curr = seq(i)
      if (!prev.isBefore(curr)) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 100) {
      val arrayA = ArrayBuffer.fill(10)(new HtWt(randomInt(100), randomInt(100)))
      val arrayB = arrayA.clone()
      val arrayC = arrayA.clone()

      val seq1 = QuestionA.longestIncreasingSeq(arrayA)
      val seq2 = QuestionB.longestIncreasingSeq(arrayB)
      val seq3 = QuestionOld.longestIncreasingSeq(arrayC)

      if (seq1.size != seq2.size || seq1.size != seq3.size) {
        println(s"ERROR: ${seq1.size}, ${seq2.size}, ${seq3.size}")
        println(seq1.toString())
        println(seq2.toString())
      } else {
        println(s"SUCCESS: ${seq1.size} == ${seq2.size} == ${seq3.size}")
        println(seq1.toString())
        println(seq2.toString())
        println(seq3.toString())
      }
    }
  }
}
