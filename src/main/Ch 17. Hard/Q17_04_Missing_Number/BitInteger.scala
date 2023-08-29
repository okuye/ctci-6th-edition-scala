package Q17_04_Missing_Number

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
  val INTEGER_SIZE: Int = 32

  def apply(value: Int): BitInteger = {
    val bits = Array.tabulate(INTEGER_SIZE)(i => ((value >> i) & 1) == 1)
    new BitInteger(bits)
  }
}

object QuestionAlternate {
  def pickMRecursively(original: Array[Int], m: Int, i: Int): Array[Int] = {
    if (i + 1 < m) {
      null
    } else if (i + 1 == m) {
      original.take(m)
    } else {
      val set = pickMRecursively(original, m, i - 1)
      val rand = new Random()
      val k = rand.nextInt(i + 1)
      if (k < m) {
        set(k) = original(i)
      }
      set
    }
  }

  def pickMIteratively(original: Array[Int], m: Int): Array[Int] = {
    if (m > original.length) {
      null
    } else {
      val subset = original.take(m).toArray
      val rand = new Random()
      for (i <- m until original.length) {
        val k = rand.nextInt(i + 1)
        if (k < m) {
          subset(k) = original(i)
        }
      }
      subset
    }
  }

  def main(args: Array[String]): Unit = {
    val cards = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(cards.mkString(", "))
    val set = pickMIteratively(cards, 4)
    println(set.mkString(", "))
  }
}