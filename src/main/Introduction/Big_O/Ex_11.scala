package Big_O

object Ex_11 {
  def reverse(array: Array[Int]): Unit = {
    val reversedArray = array.reverse
    for (x <- reversedArray) {
      println(x)
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(0, 1, 2, 3, 4, 5)
    reverse(array)
  }
}
