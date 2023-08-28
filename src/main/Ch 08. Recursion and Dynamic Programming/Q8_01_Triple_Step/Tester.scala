package Q8_01_Triple_Step

object Tester extends App {
  for (i <- 0 until 30) {
    val c1 = QuestionB.countWays(i)
    val c2 = QuestionA.countWays(i)
    println(s"$i: $c1 $c2")
  }
}
