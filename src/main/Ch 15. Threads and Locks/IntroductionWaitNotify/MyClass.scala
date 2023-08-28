package IntroductionWaitNotify

class MyClass(myObj: MyObject, name: String) extends Thread {
  override def run(): Unit = {
    try {
      myObj.synchronized {
        myObj.wait(1000)
        myObj.foo(name)
        myObj.notify()
      }
    } catch {
      case e: InterruptedException => e.printStackTrace()
    }
  }
}
