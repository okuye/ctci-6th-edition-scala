package Big_O

object Ex_03 {
  def minAndMax1(array: Array[Int]): Unit = {
    var min = Int.MaxValue
    var max = Int.MinValue
    for (x <- array) {
      if (x < min) min = x
      if (x > max) max = x
    }
    println(s"$min, $max")
  }

  def minAndMax2(array: Array[Int]): Unit = {
    var min = Int.MaxValue
    var max = Int.MinValue
    for (x <- array) {
      if (x < min) min = x
    }
    for (x <- array) {
      if (x > max) max = x
    }
    println(s"$min, $max")
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 5, 2, 2, 5, -1, 9, 3)
    minAndMax1(array)
    minAndMax2(array)
  }
}
