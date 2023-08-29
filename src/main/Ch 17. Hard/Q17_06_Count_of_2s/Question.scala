package Q17_06_Count_of_2s

object Question {

  def count2sInRangeAtDigit(number: Int, d: Int): Int = {
    val powerOf10 = Math.pow(10, d).toInt
    val nextPowerOf10 = powerOf10 * 10
    val right = number % powerOf10

    val roundDown = number - number % nextPowerOf10
    val roundUp = roundDown + nextPowerOf10

    val digit = (number / powerOf10) % 10
    digit match {
      case _ if digit < 2  => roundDown / 10
      case 2               => roundDown / 10 + right + 1
      case _               => roundUp / 10
    }
  }

  def count2sInRange(number: Int): Int = {
    val len = number.toString.length
    (0 until len).map(digit => count2sInRangeAtDigit(number, digit)).sum
  }

  def count2sR(n: Int): Int = {
    if (n == 0) {
      return 0
    }

    var power = 1
    while (10 * power < n) {
      power *= 10
    }
    val first = n / power
    val remainder = n % power

    val nTwosFirst = if (first > 2) {
      power
    } else if (first == 2) {
      remainder + 1
    } else {
      0
    }

    val nTwosOther = first * count2sR(power - 1) + count2sR(remainder)

    nTwosFirst + nTwosOther
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 10000) {
      val v1 = count2sR(i)
      val v2 = count2sInRange(i)
      println(s"Between 0 and $i: $v1 $v2")
    }
  }
}
