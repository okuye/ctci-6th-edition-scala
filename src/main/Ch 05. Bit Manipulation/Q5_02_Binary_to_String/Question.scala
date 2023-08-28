package Q5_02_Binary_to_String

object Question {

  def printBinary(num: Double): String = {
    if (num >= 1 || num <= 0) {
      return "ERROR"
    }

    val binary = new StringBuilder
    binary.append(".")
    var mutableNum = num
    while (mutableNum > 0) {
      if (binary.length > 32) {
        return "ERROR"
      }
      val r = mutableNum * 2
      if (r >= 1) {
        binary.append(1)
        mutableNum = r - 1
      } else {
        binary.append(0)
        mutableNum = r
      }
    }
    binary.toString()
  }

  def printBinary2(num: Double): String = {
    if (num >= 1 || num <= 0) {
      return "ERROR"
    }

    val binary = new StringBuilder
    var frac = 0.5
    binary.append(".")
    var mutableNum = num
    while (mutableNum > 0) {
      if (binary.length >= 32) {
        return "ERROR"
      }
      if (mutableNum >= frac) {
        binary.append(1)
        mutableNum -= frac
      } else {
        binary.append(0)
      }
      frac /= 2
    }
    binary.toString()
  }

  def main(args: Array[String]): Unit = {
    val bs = printBinary(.125)
    println(bs)

    for (i <- 0 until 1000) {
      val num = i / 1000.0
      val binary = printBinary(num)
      val binary2 = printBinary2(num)
      if (binary != "ERROR" || binary2 != "ERROR") {
        println(s"$num : $binary $binary2")
      }
    }
  }
}
