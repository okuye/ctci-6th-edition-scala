package Q15_03_Dining_Philosophers.QuestionA

object Question {
  val size = 3

  def leftOf(i: Int): Int = i

  def rightOf(i: Int): Int = (i + 1) % size

  def main(args: Array[String]): Unit = {
    val chopsticks = Array.fill(size + 1)(new Chopstick)

    val philosophers = for (i <- 0 until size) yield {
      val left = chopsticks(leftOf(i))
      val right = chopsticks(rightOf(i))
      new Philosopher(i, left, right)
    }

    philosophers.foreach(_.start())
  }
}
