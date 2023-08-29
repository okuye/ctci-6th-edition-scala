package Q16_11_Diving_Board

import scala.collection.mutable.HashSet

object Tester {

  def main(args: Array[String]): Unit = {
    val nSticks = 12
    val shorter = 2
    val longer = 3
    val lengthsA = QuestionA.allLengths(nSticks, shorter, longer)
    val lengthsB = QuestionB.allLengths(nSticks, shorter, longer)
    val lengthsC = QuestionC.allLengths(nSticks, shorter, longer)

    println(QuestionB.counter)
    println(lengthsA.mkString(", "))
    println(lengthsB.mkString(", "))
    println(lengthsC.mkString(", "))

    println(lengthsA == lengthsB && lengthsA == lengthsC)
    println(s"Calls for A: ${QuestionA.counter}")
    println(s"Calls for B: ${QuestionB.counter}")
    println(s"Calls for C: ${QuestionC.counter}")
  }
}
