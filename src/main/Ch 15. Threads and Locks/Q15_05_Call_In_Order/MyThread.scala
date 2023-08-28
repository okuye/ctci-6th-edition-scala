package Q15_05_Call_In_Order

class MyThread(foo: FooBad, method: String) extends Thread {
  override def run(): Unit = {
    method match {
      case "first" => foo.first()
      case "second" => foo.second()
      case "third" => foo.third()
      case _ => // handle other cases or do nothing
    }
  }
}
