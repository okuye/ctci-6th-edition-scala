package CompareBinaryToHex

object CompareBinaryToHex {
  def digitToValue(c: Char): Int = {
    if (c >= '0' && c <= '9') {
      c - '0'
    } else if (c >= 'A' && c <= 'F') {
      10 + c - 'A'
    } else if (c >= 'a' && c <= 'f') {
      10 + c - 'a'
    } else {
      -1
    }
  }

  def convertFromBase(number: String, base: Int): Int = {
    if (base < 2 || (base > 10 && base != 16)) return -1
    var value = 0
    for (i <- number.length - 1 to 0 by -1) {
      val digit = digitToValue(number.charAt(i))
      if (digit < 0 || digit >= base) {
        return -1
      }
      val exp = number.length - 1 - i
      value += digit * math.pow(base, exp).toInt
    }
    value
  }

  def compareBinToHex(binary: String, hex: String): Boolean = {
    val n1 = convertFromBase(binary, 2)
    val n2 = convertFromBase(hex, 16)
    if (n1 < 0 || n2 < 0) {
      false
    } else {
      n1 == n2
    }
  }

  def main(args: Array[String]): Unit = {
    println(compareBinToHex("111001011", "1CB"))
  }
}
