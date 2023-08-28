package Q15_06_Synchronized_Methods

class MyThread(f: Foo, nm: String, fM: String) extends Thread {
  private val foo: Foo = f
  val name: String = nm
  val firstMethod: String = fM

  override def run(): Unit = {
    firstMethod match {
      case "A" => foo.methodA(name)
      case _ => foo.methodB(name)
    }
  }
}
