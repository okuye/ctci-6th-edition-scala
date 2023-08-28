package Q8_01_Triple_Step

object QuestionB extends App {

  def countWays(n: Int): Int = {
    val memo = Array.fill(n + 1)(-1)
    countWays(n, memo)
  }

  def countWays(n: Int, memo: Array[Int]): Int = {
    if (n < 0) {
      0
    } else if (n == 0) {
      1
    } else if (memo(n) > -1) {
      memo(n)
    } else {
      memo(n) =
        countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo)
      memo(n)
    }
  }

  val n = 50
  val ways = countWays(n)
  println(ways)
}
