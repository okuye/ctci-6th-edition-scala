package IntroductionSynchronization

class MyClass(name: String) extends Thread {
  override def run(): Unit = {
    name match {
      case "1" => MyObject.foo(name)
      case "2" => MyObject.bar(name)
      case _ => // handle other cases if needed
    }
  }
}
