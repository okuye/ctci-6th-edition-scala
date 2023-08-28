package IntroductionB

object ExampleB {
  def main(args: Array[String]): Unit = {
    val instance = new ThreadExample()
    instance.start()

    while (instance.getCount != 5) {
      try {
        Thread.sleep(250)
      } catch {
        case exc: InterruptedException => exc.printStackTrace()
      }
    }
  }
}
