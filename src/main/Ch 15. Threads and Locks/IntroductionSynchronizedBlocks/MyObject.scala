package IntroductionSynchronizedBlocks

class MyObject {
  def foo(name: String): Unit = synchronized {
    try {
      println(s"Thread $name.foo(): starting")
      Thread.sleep(3000)
      println(s"Thread $name.foo(): ending")
    } catch {
      case exc: InterruptedException => println(s"Thread $name: interrupted.")
    }
  }
}
