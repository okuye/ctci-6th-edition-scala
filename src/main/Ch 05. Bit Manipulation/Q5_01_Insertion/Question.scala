package Q5_01_Insertion

import CtCILibrary.AssortedMethods

object Question {

  def updateBits(n: Int, m: Int, i: Int, j: Int): Int = {
    // Validation
    if (i > j || i < 0 || j >= 32) {
      return 0
    }

    val allOnes = ~0 // allOnes = 11111111

    val left = if (j < 31) (allOnes << (j + 1)) else 0
    val right = ((1 << i) - 1)
    val mask = left | right

    val n_cleared = n & mask
    val m_shifted = m << i

    n_cleared | m_shifted
  }

  def main(args: Array[String]): Unit = {
    val a = ~23423
    println(AssortedMethods.toFullBinaryString(a))
    val b = 5
    println(AssortedMethods.toFullBinaryString(b))
    val c = updateBits(a, b, 29, 31)
    println(AssortedMethods.toFullBinaryString(c))
  }
}
