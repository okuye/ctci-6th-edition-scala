package Q17_19_Missing_Two

import java.math.BigInteger

object QuestionA {
  def productToN(n: Int): BigInteger = {
    var fullProduct = BigInteger.ONE
    for (i <- 2 to n) {
      fullProduct = fullProduct.multiply(BigInteger.valueOf(i))
    }
    fullProduct
  }

  def missingOne(array: Array[Int]): Int = {
    val fullProduct = productToN(array.length + 1)

    var actualProduct = BigInteger.ONE
    for (i <- array.indices) {
      val value = BigInteger.valueOf(array(i))
      actualProduct = actualProduct.multiply(value)
    }

    val missingNumber = fullProduct.divide(actualProduct)
    missingNumber.intValue()
  }

  def main(args: Array[String]): Unit = {
    val max = 100
    val x = 8
    val len = max - 1
    var count = 0
    val array = new Array[Int](len)
    for (i <- 1 to max) {
      if (i != x) {
        array(count) = i
        count += 1
      }
    }
    println(x)
    val solution = missingOne(array)

    println(solution)
  }
}
