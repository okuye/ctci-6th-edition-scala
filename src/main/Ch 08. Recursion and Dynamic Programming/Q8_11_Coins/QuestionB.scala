object QuestionB {

  def makeChange(n: Int, denoms: Array[Int]): Int = {
    val map = Array.ofDim[Int](n + 1, denoms.length)
    makeChangeHelper(n, denoms, 0, map)
  }

  def makeChangeHelper(
      total: Int,
      denoms: Array[Int],
      index: Int,
      map: Array[Array[Int]]
  ): Int = {
    // Check cache for prior result.
    if (map(total)(index) > 0) { // retrieve value
      return map(total)(index)
    }

    val coin = denoms(index)
    if (index == denoms.length - 1) {
      val remaining = total % coin
      if (remaining == 0) 1 else 0
    } else {
      var numberOfWays = 0
      // Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest).
      var amount = 0
      while (amount <= total) {
        numberOfWays += makeChangeHelper(
          total - amount,
          denoms,
          index + 1,
          map
        ) // go to next denom
        amount += coin
      }

      // Update cache with current result.
      map(total)(index) = numberOfWays

      numberOfWays
    }
  }

  def main(args: Array[String]): Unit = {
    val denoms = Array(25, 10, 5, 1)
    val ways = makeChange(10, denoms)
    println(ways)
  }
}
