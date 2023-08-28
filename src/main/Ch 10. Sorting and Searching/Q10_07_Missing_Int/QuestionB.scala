package Q10_07_Missing_Int

import scala.io.Source
import java.io.PrintWriter

object QuestionB {

  def findOpenNumber(filename: String): Int = {
    val rangeSize = 1 << 20 // 2^20 bits (2^17 bytes)

    val blocks = getCountPerBlock(filename, rangeSize)

    val blockIndex = findBlockWithMissing(blocks, rangeSize)
    if (blockIndex < 0) return -1

    val bitVector = getBitVectorForRange(filename, blockIndex, rangeSize)

    val offset = findZero(bitVector)
    if (offset < 0) return -1

    blockIndex * rangeSize + offset
  }

  def getCountPerBlock(filename: String, rangeSize: Int): Array[Int] = {
    val arraySize = Integer.MAX_VALUE / rangeSize + 1
    val blocks = Array.fill(arraySize)(0)

    for (value <- Source.fromFile(filename).getLines().map(_.toInt)) {
      blocks(value / rangeSize) += 1
    }

    blocks
  }

  def findBlockWithMissing(blocks: Array[Int], rangeSize: Int): Int = {
    blocks.indexWhere(_ < rangeSize)
  }

  def getBitVectorForRange(filename: String, blockIndex: Int, rangeSize: Int): Array[Byte] = {
    val startRange = blockIndex * rangeSize
    val endRange = startRange + rangeSize
    val bitVector = Array.fill(rangeSize / 8)(0.toByte)

    for (value <- Source.fromFile(filename).getLines().map(_.toInt) if value >= startRange && value < endRange) {
      val offset = value - startRange
      bitVector(offset / 8) = (bitVector(offset / 8) | (1 << (offset % 8))).toByte
    }

    bitVector
  }

  def findZero(b: Byte): Int = {
    (0 until 8).find(i => (b & (1 << i)) == 0).getOrElse(-1)
  }

  def findZero(bitVector: Array[Byte]): Int = {
    bitVector.zipWithIndex.find { case (byte, _) => byte != ~0.toByte } match {
      case Some((byte, i)) => i * 8 + findZero(byte)
      case None => -1
    }
  }

  def generateFile(filename: String, max: Int, missing: Int): Unit = {
    val writer = new PrintWriter(filename)

    for (i <- 0 until max if i != missing) {
      writer.println(i)
      if (i % 10000 == 0) {
        println(s"Now at location: $i")
      }
    }

    writer.flush()
    writer.close()
  }

  def main(args: Array[String]): Unit = {
    val filename = "Ch 10. Scalability and Memory Limits/Q10_04_Missing_Int/input.txt"
    val max = 10000000
    val missing = 1234325

    println("Generating file...")
    generateFile(filename, max, missing)
    println(s"Generated file from 0 to $max with $missing missing.")
    println("Searching for missing number...")
    println(s"Missing value: ${findOpenNumber(filename)}")
  }
}
