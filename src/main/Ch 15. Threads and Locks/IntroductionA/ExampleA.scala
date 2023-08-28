package IntroductionA

object ExampleA {

  def main(args: Array[String]): Unit = {
    val instance = new RunnableThreadExample()
    val thread = new Thread(instance)
    thread.start()

    /* waits until earlier thread counts to 5 (slowly) */
    while (instance.count != 5) {
      try {
        Thread.sleep(250)
      } catch {
        case exc: InterruptedException => exc.printStackTrace()
      }
    }

    println("Program Terminating.")
  }
}
