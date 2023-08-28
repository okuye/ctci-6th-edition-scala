package Q8_05_Recursive_Multiply

object QuestionA {

  var counter = 0

  def sum(x: Int, y: Int): Int = {
    counter += 1
    x + y
  }

  def minProductHelper(smaller: Int, bigger: Int): Int = {
    if (smaller == 0) {
      return 0
    } else if (smaller == 1) {
      return bigger
    }

    val s = smaller >> 1
    val side1 = minProductHelper(s, bigger)
    var side2 = side1
    if (smaller % 2 == 1) {
      counter += 1
      side2 = minProductHelper(smaller - s, bigger)
    }
    counter += 1
    side1 + side2
  }

  def minProduct(a: Int, b: Int): Int = {
    val bigger = Math.max(a, b)
    val smaller = Math.min(a, b)
    minProductHelper(smaller, bigger)
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
