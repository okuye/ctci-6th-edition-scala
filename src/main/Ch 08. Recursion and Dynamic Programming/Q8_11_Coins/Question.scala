object Question {

  def makeChangeHelper(total: Int, denoms: Array[Int], index: Int): Int = {
    val coin = denoms(index)
    if (index == denoms.length - 1) { // One denom left, either you can do it or not
      val remaining = total % coin
      if (remaining == 0) 1 else 0
    } else {
      var ways = 0
      // Try 1 coin, then 2 coins, 3 three, ... (recursing each time on rest).
      var amount = 0
      while (amount <= total) {
        ways += makeChangeHelper(total - amount, denoms, index + 1) // go to next denom
        amount += coin
      }
      ways
    }
  }

  def makeChange(amount: Int, denoms: Array[Int]): Int = {
    makeChangeHelper(amount, denoms, 0)
  }

  def main(args: Array[String]): Unit = {
    val denoms = Array(25, 10, 5, 1)
    val ways = makeChange(10, denoms)
    println(ways)
  }
}
