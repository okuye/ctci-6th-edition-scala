package Q15_07_FizzBuzz

object QuestionC {

  def main(args: Array[String]): Unit = {
    val n = 100
    val threads = Array(
      new FBThread(i => i % 3 == 0 && i % 5 == 0, i => "FizzBuzz", n),
      new FBThread(i => i % 3 == 0 && i % 5 != 0, i => "Fizz", n),
      new FBThread(i => i % 3 != 0 && i % 5 == 0, i => "Buzz", n),
      new FBThread(i => i % 3 != 0 && i % 5 != 0, i => i.toString, n)
    )

    threads.foreach(_.start())
  }
}
