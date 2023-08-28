package Q8_05_Recursive_Multiply

object Tester {

  def main(args: Array[String]): Unit = {
    val max = 1000
    var counterA = 0
    var counterB = 0
    var counterC = 0
    var counterD = 0

    for (a <- 0 until max; b <- 0 until max) {
      val prodA = QuestionA.minProduct(a, b)
      val prodB = QuestionB.minProduct(a, b)
      val prodC = QuestionC.minProduct(a, b)
      val prodD = QuestionD.minProduct(a, b)

      val product = a * b

      counterA += QuestionA.counter
      counterB += QuestionB.counter
      counterC += QuestionC.counter
      counterD += QuestionD.counter

      QuestionA.counter = 0
      QuestionB.counter = 0
      QuestionC.counter = 0
      QuestionD.counter = 0

      if (prodA != product || prodB != product || prodC != product || prodD != product) {
        println(s"Failure: $a * $b = $product instead of ($prodA, $prodB, $prodC, $prodD)")
      }
    }

    println()
    println(s"A: $counterA")
    println(s"B: $counterB")
    println(s"C: $counterC")
    println(s"D: $counterD")
  }
}
