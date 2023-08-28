package Q8_05_Recursive_Multiply

object QuestionB {

  var counter = 0

  def sum(x: Int, y: Int): Int = {
    counter += 1
    x + y
  }

  def minProduct(smaller: Int, bigger: Int, memo: Array[Int]): Int = {
    if (smaller == 0) {
      0
    } else if (smaller == 1) {
      bigger
    } else if (memo(smaller) > 0) {
      memo(smaller)
    } else {
      val s = smaller >> 1
      val side1 = minProduct(s, bigger, memo)
      var side2 = side1
      if (smaller % 2 == 1) {
        counter += 1
        side2 = minProduct(smaller - s, bigger, memo)
      }
      counter += 1
      memo(smaller) = side1 + side2
      memo(smaller)
    }
  }

  def minProduct(a: Int, b: Int): Int = {
    val bigger = Math.max(a, b)
    val smaller = Math.min(a, b)
    val memo = new Array[Int](sum(smaller, 1))
    minProduct(smaller, bigger, memo)
  }

  def main(args: Array[String]): Unit = {
    val a = 13494
    val b = 22323
    val product = a * b
    val minProd = minProduct(a, b)
    if (product == minProd) {
      println(s"Success: $a * $b = $product")
    } else {
      println(s"Failure: $a * $b = $product instead of $minProd")
    }
    println(s"Adds: $counter")
  }
}
