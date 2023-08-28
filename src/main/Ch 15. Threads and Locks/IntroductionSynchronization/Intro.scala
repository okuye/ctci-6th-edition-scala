package IntroductionSynchronization

object Intro {
  def main(args: Array[String]): Unit = {
    try {
      val thread1 = new MyClass("1")
      val thread2 = new MyClass("2")

      thread1.start()
      thread2.start()

      Thread.sleep(3000 * 3)
    } catch {
      case exc: InterruptedException =>
        println("Program Interrupted.")
    }
    println("Program terminating.")
  }
}
