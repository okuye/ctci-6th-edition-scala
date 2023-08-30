package Big_O

object Ex_04 {
  def foo(arrA: Array[Int], arrB: Array[Int]): Unit = {
    for (a <- arrA) {
      println(a)
    }
    for (b <- arrB) {
      println(b)
    }
  }

  def bar(arrA: Array[Int], arrB: Array[Int]): Unit = {
    for (a <- arrA) {
      for (b <- arrB) {
        println(s"$a,$b")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val arrA = Array(1, 2, 5, 2, 2, 5, -1, 9, 3)
    val arrB = Array(5, 2, 1, 0, 2)
    foo(arrA, arrB)
    bar(arrA, arrB)
  }
}
