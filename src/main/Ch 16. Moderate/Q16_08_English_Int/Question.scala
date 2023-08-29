package Q16_08_English_Int

import scala.collection.mutable.ListBuffer

object Question {
  val smalls = Array(
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen"
  )
  val tens = Array(
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety"
  )
  val bigs = Array("", "Thousand", "Million", "Billion")
  val hundred = "Hundred"
  val negative = "Negative"

  def convert(num: Int): String = {
    if (num == 0) {
      smalls(0)
    } else if (num < 0) {
      negative + " " + convert(-num)
    } else {
      val parts = ListBuffer[String]()
      var chunkCount = 0
      var currentNum = num

      while (currentNum > 0) {
        if (currentNum % 1000 != 0) {
          val chunk = convertChunk(currentNum % 1000) + " " + bigs(chunkCount)
          parts.prepend(chunk)
        }
        currentNum /= 1000
        chunkCount += 1
      }

      parts.mkString(" ")
    }
  }

  def convertChunk(number: Int): String = {
    val parts = ListBuffer[String]()
    var currentNum = number

    if (currentNum >= 100) {
      parts.append(smalls(currentNum / 100))
      parts.append(hundred)
      currentNum %= 100
    }

    if (currentNum >= 10 && currentNum <= 19) {
      parts.append(smalls(currentNum))
    } else if (currentNum >= 20) {
      parts.append(tens(currentNum / 10))
      currentNum %= 10
    }

    if (currentNum >= 1 && currentNum <= 9) {
      parts.append(smalls(currentNum))
    }

    parts.mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    // Replacing with Scala's Random utility
    val rand = new scala.util.Random

    // Mocking the test cases, as per the original Java code
    for (_ <- 0 until 10) {
      val value = rand.nextInt(100000000 - 100000) + 100000
      val s = convert(value)
      println(s"$value: $s")
    }
    // You can replicate the rest of the tests in a similar fashion
  }
}
