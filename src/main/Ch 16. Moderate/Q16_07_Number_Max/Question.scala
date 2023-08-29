package Q16_07_Number_Max

object Question {
  /* Flips a 1 to a 0 and a 0 to a 1 */
  def flip(bit: Int): Int = 1 ^ bit

  /* Returns 1 if a is positive, and 0 if a is negative */
  def sign(a: Int): Int = flip((a >> 31) & 0x1)

  def getMaxNaive(a: Int, b: Int): Int = {
    val k = sign(a - b)
    val q = flip(k)
    a * k + b * q
  }

  def getMax(a: Int, b: Int): Int = {
    val c = a - b

    val sa = sign(a)
    val sb = sign(b)
    val sc = sign(c)

    val use_sign_of_a = sa ^ sb
    val use_sign_of_c = flip(sa ^ sb)

    val k = use_sign_of_a * sa + use_sign_of_c * sc
    val q = flip(k)

    a * k + b * q
  }

  def main(args: Array[String]): Unit = {
    var a = 26
    var b = -15

    println(s"max_naive($a, $b) = ${getMaxNaive(a, b)}")
    println(s"max($a, $b) = ${getMax(a, b)}")

    a = -15
    b = 2147483647

    println(s"max_naive($a, $b) = ${getMaxNaive(a, b)}")
    println(s"max($a, $b) = ${getMax(a, b)}")
  }
}
