package IntroductionWaitNotify

object Intro {
  def main(args: Array[String]): Unit = {
    try {
      val obj1 = new MyObject()
      val obj2 = new MyObject()

      val thread1 = new MyClass(obj1, "1")
      val thread2 = new MyClass(obj1, "2")

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
