package Q10_07_Missing_Int

import scala.io.Source

object QuestionA {
  val numberOfInts: Long = Integer.MAX_VALUE.toLong + 1
  val bitfield: Array[Byte] = Array.fill((numberOfInts / 8).toInt)(0.toByte)

  def findOpenNumber(): Unit = {
    val source = Source.fromFile("Ch 10. Sorting and Searching/Q10_07_Missing_Int/input.txt")
    for (n <- source.getLines().map(_.toInt)) {
      bitfield(n / 8) = (bitfield(n / 8) | (1 << (n % 8))).toByte
    }
    source.close()

    for (i <- bitfield.indices; j <- 0 until 8 if (bitfield(i) & (1 << j)) == 0) {
      println(i * 8 + j)
      return
    }
  }

  def main(args: Array[String]): Unit = {
    findOpenNumber()
  }
}
