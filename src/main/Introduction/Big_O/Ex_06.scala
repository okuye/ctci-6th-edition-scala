package Big_O

object Ex_06 {
  def foo(array: Array[Int]): Unit = {
    val sum = array.sum
    val product = array.product
    println(s"$sum, $product")
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 5, 2, 2, 5, -1, 9, 3)
    foo(array)
  }
}

