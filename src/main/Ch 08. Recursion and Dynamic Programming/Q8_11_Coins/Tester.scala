object Tester {

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 200) {
      val denoms = Array(25, 10, 5, 1)
      val waysA = Question.makeChange(i, denoms)
      val waysB = QuestionB.makeChange(i, denoms)
      if (waysA != waysB) {
        println(s"Error: $i : $waysA, $waysB")
      }
    }
  }
}
