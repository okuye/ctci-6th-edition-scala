package Q8_01_Triple_Step

object QuestionA extends App {

  def countWays(n: Int): Int = {
    if (n < 0) {
      0
    } else if (n == 0) {
      1
    } else {
      countWays(n - 1) + countWays(n - 2) + countWays(n - 3)
    }
  }

  val n = 20
  val ways = countWays(n)
  println(ways)
}
