import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class BitInteger(val bits: Array[Boolean]) {
  def fetch(k: Int): Int = if (bits(k)) 1 else 0

  def set(k: Int, bitValue: Int): Unit = bits(k) = bitValue != 0

  def set(k: Int, bitValue: Char): Unit = bits(k) = bitValue != '0'

  def set(k: Int, bitValue: Boolean): Unit = bits(k) = bitValue

  def swapValues(number: BitInteger): Unit = {
    for (i <- bits.indices) {
      val temp = number.fetch(i)
      number.set(i, this.fetch(i))
      this.set(i, temp)
    }
  }

  def toInt: Int = bits.zipWithIndex.foldLeft(0) { case (number, (bit, j)) =>
    number | (if (bit) 1 else 0) << (BitInteger.INTEGER_SIZE - 1 - j)
  }
}

object BitInteger {
  var INTEGER_SIZE: Int = 0

  def apply(value: Int): BitInteger = {
    val binaryString = BigInt(value).toString(2)
    val bits = Array.tabulate(INTEGER_SIZE)(i => if (i < binaryString.length) binaryString.charAt(binaryString.length - 1 - i) == '1' else false)
    new BitInteger(bits)
  }
}

object Question {
  def initialize(n: Int, missing: Int): ArrayBuffer[BitInteger] = {
    BitInteger.INTEGER_SIZE = Integer.toBinaryString(n).length
    val array = ArrayBuffer[BitInteger]()

    for (i <- 1 to n) {
      array += BitInteger(if (i == missing) 0 else i) // Corrected line
    }

    for (i <- 0 until n) {
      val rand = i + Random.nextInt(n - i)
      array(i).swapValues(array(rand))
    }

    array
  }

  def findMissing(input: ArrayBuffer[BitInteger]): Int = {
    findMissing(input, BitInteger.INTEGER_SIZE - 1)
  }

  private def findMissing(input: ArrayBuffer[BitInteger], column: Int): Int = {
    if (column < 0) {
      0
    } else {
      val oneBits = ArrayBuffer[BitInteger]()
      val zeroBits = ArrayBuffer[BitInteger]()
      for (t <- input) {
        if (t.fetch(column) == 0) {
          zeroBits += t
        } else {
          oneBits += t
        }
      }
      if (zeroBits.size <= oneBits.size) {
        val v = findMissing(zeroBits, column - 1)
        print("0")
        (v << 1) | 0
      } else {
        val v = findMissing(oneBits, column - 1)
        print("1")
        (v << 1) | 1
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val rand = new Random()
    val n = rand.nextInt(300000) + 1
    val missing = rand.nextInt(n + 1)
    val array = initialize(n, missing)
    println(s"The array contains all numbers but one from 0 to $n, except for $missing")

    val result = findMissing(array)
    if (result != missing) {
      println(s"Error in the algorithm!\nThe missing number is $missing, but the algorithm reported $result")
    } else {
      println(s"The missing number is $result")
    }
  }
}