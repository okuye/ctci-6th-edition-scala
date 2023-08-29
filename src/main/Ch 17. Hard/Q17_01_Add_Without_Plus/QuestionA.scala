package Q17_01_Add_Without_Plus

object QuestionA {
  def add(a: Int, b: Int): Int = {
    if (b == 0) a
    else {
      val sum = a ^ b // add without carrying
      val carry = (a & b) << 1 // carry, but don't add
      add(sum, carry) // recurse
    }
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