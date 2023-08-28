package IntroductionA

class RunnableThreadExample extends Runnable {
  var count: Int = 0

  override def run(): Unit = {
    println("RunnableThread starting.")
    try {
      while (count < 5) {
        Thread.sleep(500)
        println(s"RunnableThread count: $count")
        count += 1
      }
    } catch {
      case _: InterruptedException => println("RunnableThread interrupted.")
    }
    println("RunnableThread terminating.")
  }
}
