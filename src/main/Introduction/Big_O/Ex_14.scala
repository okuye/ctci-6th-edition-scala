package Big_O

object Ex_14 {
  def isPrime(n: Int): Boolean = {
    if (n <= 1) {
      false
    } else {
      !(2 to math.sqrt(n).toInt).exists(x => n % x == 0)
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(2, 3, 4, 5, 6, 7, 8, 9, 10)
    for (x <- array) {
      val isPrimeNumber = isPrime(x)
      if (isPrimeNumber) {
        println(s"$x: prime")
      } else {
        println(s"$x: not prime")
      }
    }
  }
}
