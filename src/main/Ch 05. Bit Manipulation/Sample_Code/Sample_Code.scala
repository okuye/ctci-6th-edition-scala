package Sample_Code

object Sample_Code {

  def getBit(num: Int, i: Int): Boolean = (num & (1 << i)) != 0

  def setBit(num: Int, i: Int): Int = num | (1 << i)

  def clearBit(num: Int, i: Int): Int = {
    val mask = ~(1 << i)
    num & mask
  }

  def updateBit(num: Int, i: Int, bitIs1: Boolean): Int = {
    val value = if (bitIs1) 1 else 0
    val mask = ~(1 << i)
    (num & mask) | (value << i)
  }

  def clearBitsMSBthroughI(num: Int, i: Int): Int = {
    val mask = (1 << i) - 1
    num & mask
  }

  def clearBitsIthrough0(num: Int, i: Int): Int = {
    val mask = -1 << (i + 1)
    num & mask
  }

  def main(args: Array[String]): Unit = {

    val number = 59
    println(s"Testing with number: $number")

    // Get Bit
    println("Get Bit")
    println(number.toBinaryString)
    for (i <- 31 to 0 by -1) {
      val res = if (getBit(number, i)) 1 else 0
      print(res)
    }

    // Update Bit
    println("\n\nUpdate Bit")
    var num1 = 1578 // arbitrary number
    for (i <- 31 to 0 by -1) {
      num1 = updateBit(num1, i, getBit(number, i))
    }
    println(num1)

    // Set and Clear Bit
    println("\nSet and Clear Bit")
    var num2 = 1578 // arbitrary number
    for (i <- 31 to 0 by -1) {
      if (getBit(number, i)) {
        num2 = setBit(num2, i)
      } else {
        num2 = clearBit(num2, i)
      }
    }
    println(num2)

    // Clear Bits MSB through i
    var newNumber = 13242352
    val clearMSBThrough = 4
    println(s"\nClear bits MSB through $clearMSBThrough")
    println(newNumber.toBinaryString)
    val num3 = clearBitsMSBthroughI(newNumber, clearMSBThrough)
    println(num3.toBinaryString)

    // Clear Bits i through 0
    val clearToLSB = 2
    println(s"\nClear bits $clearToLSB through 0")
    newNumber = -1
    println(newNumber.toBinaryString)
    val num4 = clearBitsIthrough0(newNumber, clearToLSB)
    println(num4.toBinaryString)
  }
}
