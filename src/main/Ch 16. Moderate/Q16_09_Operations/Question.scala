package Q16_09_Operations

import scala.util.Random

object Question {

  def negate(a: Int): Int = {
    var neg = 0
    val newSign = if (a < 0) 1 else -1
    var value = a
    while (value != 0) {
      neg += newSign
      value += newSign
    }
    neg
  }

  def negateOptimized(a: Int): Int = {
    var neg = 0
    val newSign = if (a < 0) 1 else -1
    var delta = newSign
    var value = a
    while (value != 0) {
      val differentSigns = (value + delta > 0) != (value > 0)
      if (value + delta != 0 && differentSigns) {
        delta = newSign
      }
      neg += delta
      value += delta
      delta += delta
    }
    neg
  }

  def minus(a: Int, b: Int): Int = a + negate(b)

  def abs(a: Int): Int = if (a < 0) negateOptimized(a) else a

  def multiply(a: Int, b: Int): Int = {
    if (a < b) return multiply(b, a)
    var sum = 0
    for (_ <- 1 to abs(b)) {
      sum += a
    }
    if (b < 0) negateOptimized(sum) else sum
  }

  def divide(a: Int, b: Int): Int = {
    if (b == 0) throw new ArithmeticException("ERROR: Divide by zero.")
    val absa = abs(a)
    val absb = abs(b)
    var product = 0
    var x = 0
    while (product + absb <= absa) {
      product += absb
      x += 1
    }
    if ((a < 0 && b < 0) || (a > 0 && b > 0)) x else negateOptimized(x)
  }

  def main(args: Array[String]): Unit = {
    val minRange = -100
    val maxRange = 100
    val cycles = 100
    val rand = new Random()

    for (_ <- 1 to cycles) {
      val a = rand.nextInt(maxRange - minRange + 1) + minRange
      val b = rand.nextInt(maxRange - minRange + 1) + minRange
      val ans = minus(a, b)
      if (ans != a - b) {
        println("ERROR")
      }
      println(s"$a - $b = $ans")
    }

    for (_ <- 1 to cycles) {
      val a = rand.nextInt(maxRange - minRange + 1) + minRange
      val b = rand.nextInt(maxRange - minRange + 1) + minRange
      val ans = multiply(a, b)
      if (ans != a * b) {
        println("ERROR")
      }
      println(s"$a * $b = $ans")
    }

    for (_ <- 1 to cycles) {
      val a = rand.nextInt(maxRange - minRange + 1) + minRange
      val b = rand.nextInt(maxRange - minRange + 1) + minRange
      print(s"$a / $b = ")
      val ans = divide(a, b)
      if (ans != a / b) {
        println("ERROR")
      }
      println(ans)
    }
  }
}
