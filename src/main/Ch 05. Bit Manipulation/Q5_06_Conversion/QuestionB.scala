package Q5_06_Conversion

import CtCILibrary.AssortedMethods

object QuestionB {

  def bitSwapRequired(a: Int, b: Int): Int = {
    var count = 0
    var c = a ^ b

    println("****")
    println(s"$c: ${AssortedMethods.toFullBinaryString(c)}")
    while (c != 0) {
      println(s"c - 1: $c: ${AssortedMethods.toFullBinaryString(c - 1)}")
      c = c & (c-1)
      println(s"c: $c: ${AssortedMethods.toFullBinaryString(c)}")
      count += 1
      println("****")
    }
    count
  }

  def main(args: Array[String]): Unit = {
    val a = -23432
    val b = 512132
    println(s"$a: ${AssortedMethods.toFullBinaryString(a)}")
    println(s"$b: ${AssortedMethods.toFullBinaryString(b)}")
    println(s"Required number of bits: ${bitSwapRequired(a, b)}")
  }
}
