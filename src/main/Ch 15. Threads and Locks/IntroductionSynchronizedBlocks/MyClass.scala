package IntroductionSynchronizedBlocks

class MyClass(myObj: MyObject, name: String) extends Thread {
  override def run(): Unit = {
    myObj.foo(name)
  }
}
