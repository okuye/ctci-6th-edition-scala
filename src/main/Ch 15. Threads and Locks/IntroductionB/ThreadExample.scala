package IntroductionB

class ThreadExample extends Thread {
  private var count = 0

  override def run(): Unit = {
    println("Thread starting.")
    try {
      while (count < 5) {
        Thread.sleep(500)
        println(s"In Thread, count is $count")
        count += 1
      }
    } catch {
      case exc: InterruptedException => println("Thread interrupted.")
    }
    println("Thread terminating.")
  }

  def getCount: Int = count
}
