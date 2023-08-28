package Q8_05_Recursive_Multiply

object QuestionC {

  var counter = 0

  def minProductHelper(smaller: Int, bigger: Int): Int = {
    if (smaller == 0) {
      0
    } else if (smaller == 1) {
      bigger
    } else {
      val s = smaller >> 1
      val halfProd = minProductHelper(s, bigger)

      if (smaller % 2 == 0) {
        counter += 1
        halfProd + halfProd
      } else {
        counter += 2
        halfProd + halfProd + bigger
      }
    }
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
