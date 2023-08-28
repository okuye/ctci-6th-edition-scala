package Q15_03_Dining_Philosophers.QuestionB

object Question {
  val size: Int = 3

  def leftOf(i: Int): Int = i

  def rightOf(i: Int): Int = (i + 1) % size

  def main(args: Array[String]): Unit = {
    val chopsticks = Array.tabulate(size + 1)(i => new Chopstick(i))
    val philosophers = Array.tabulate(size) { i =>
      new Philosopher(i, chopsticks(leftOf(i)), chopsticks(rightOf(i)))
    }
    philosophers.foreach(_.start())
  }
}
