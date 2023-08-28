package Q15_06_Synchronized_Methods

class Foo(nm: String) {
  private val name: String = nm

  def getName: String = name

  private def pause(): Unit = {
    try {
      Thread.sleep(1000 * 3)
    } catch {
      case e: InterruptedException => e.printStackTrace()
    }
  }

  def methodA(threadName: String): Unit = synchronized {
    println(s"thread $threadName starting: $name.methodA()")
    pause()
    println(s"thread $threadName ending: $name.methodA()")
  }

  def methodB(threadName: String): Unit = {
    println(s"thread $threadName starting: $name.methodB()")
    pause()
    println(s"thread $threadName ending: $name.methodB()")
  }
}
