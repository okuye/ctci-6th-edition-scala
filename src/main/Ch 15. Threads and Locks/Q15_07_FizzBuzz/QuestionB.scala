package Q15_07_FizzBuzz

object QuestionB {

  def main(args: Array[String]): Unit = {
    val n = 100
    val threads = Array(
      new FizzBuzzThread(true, true, n, "FizzBuzz"),
      new FizzBuzzThread(true, false, n, "Fizz"),
      new FizzBuzzThread(false, true, n, "Buzz"),
      new NumberThread(false, false, n)
    )

    threads.foreach(_.start())
  }
}
