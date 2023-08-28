package Introduction

object PrimeNumbers {

  def primeNaive(n: Int): Boolean = {
    for (i <- 2 until n) {
      if (n % i == 0) {
        return false
      }
    }
    true
  }

  def primeSlightlyBetter(n: Int): Boolean = {
    val sqrt = Math.sqrt(n).toInt
    for (i <- 2 to sqrt) {
      if (n % i == 0) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    for (i <- 2 until 100) {
      if (primeSlightlyBetter(i)) {
        println(i)
      }
    }
  }
}
