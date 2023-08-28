package Sample_Code

object RightShifts {
  def repeatedArithmeticShift(x: Int, count: Int): Int = {
    var result = x
    for (_ <- 0 until count) {
      result >>= 1 // Arithmetic shift by 1
    }
    result
  }

  def repeatedLogicalShift(x: Int, count: Int): Int = {
    var result = x
    for (_ <- 0 until count) {
      result >>>= 1 // Logical shift by 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    for (i <- 8 to -8 by -1) {
      println(f"${i.toBinaryString}%32s: $i")
    }

    val x = -93242
    val resultArithmetic = repeatedArithmeticShift(x, 40)
    val resultLogical = repeatedLogicalShift(x, 40)
    println(f"${resultArithmetic.toBinaryString}%32s: $resultArithmetic")
    println(f"${resultLogical.toBinaryString}%32s: $resultLogical")
  }
}
