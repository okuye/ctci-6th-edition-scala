package Introduction

object SieveOfEratosthenes {

  def crossOff(flags: Array[Boolean], prime: Int): Unit = {
    for (i <- prime * prime until flags.length by prime) {
      flags(i) = false
    }
  }

  def getNextPrime(flags: Array[Boolean], prime: Int): Int = {
    var next = prime + 1
    while (next < flags.length && !flags(next)) {
      next += 1
    }
    next
  }

  def init(flags: Array[Boolean]): Unit = {
    flags(0) = false
    flags(1) = false
    for (i <- 2 until flags.length) {
      flags(i) = true
    }
  }

  def prune(flags: Array[Boolean], count: Int): Array[Int] = {
    val primes = new Array[Int](count)
    var index = 0
    for (i <- flags.indices) {
      if (flags(i)) {
        primes(index) = i
        index += 1
      }
    }
    primes
  }

  def sieveOfEratosthenes(max: Int): Array[Boolean] = {
    val flags = new Array[Boolean](max + 1)

    init(flags)
    var prime = 2

    while (prime <= Math.sqrt(max)) {
      crossOff(flags, prime)
      prime = getNextPrime(flags, prime)
    }

    flags
  }

  def main(args: Array[String]): Unit = {
    val primes = sieveOfEratosthenes(4)
    for (i <- primes.indices) {
      if (primes(i)) {
        println(i)
      }
    }
  }
}
