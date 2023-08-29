package Q16_01_Number_Swapper

object Question {

  def swap(a: Int, b: Int): Unit = {
    var x = a
    var y = b
    x = x - y
    y = x + y
    x = y - x

    println("a: " + x)
    println("b: " + y)
  }

  def swap_opt(a: Int, b: Int): Unit = {
    var x = a
    var y = b
    x = x ^ y
    y = x ^ y
    x = x ^ y

    println("a: " + x)
    println("b: " + y)
  }

  def main(args: Array[String]): Unit = {
    val a = 1672
    val b = 9332

    println("a: " + a)
    println("b: " + b)

    swap(a, b)
    swap_opt(a, b)
  }

}
