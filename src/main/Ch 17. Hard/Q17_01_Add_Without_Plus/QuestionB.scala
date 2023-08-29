package Q17_01_Add_Without_Plus

object QuestionB {
  def add(a: Int, b: Int): Int = {
    var x = a
    var y = b
    while (y != 0) {
      val sum = x ^ y // add without carrying
      val carry = (x & y) << 1 // carry, but don't add
      x = sum
      y = carry
    }
    x
  }

  def main(args: Array[String]): Unit = {
    val a = Integer.MAX_VALUE - 50
    val b = 92
    val sum = add(a, b)
    val intendedSum = a + b
    if (sum != intendedSum) {
      println("ERROR")
    } else {
      println("SUCCESS")
    }
    println(s"$a + $b = $sum vs $intendedSum")
  }
}