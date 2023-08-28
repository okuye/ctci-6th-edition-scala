package Q15_05_Call_In_Order

object Question extends App {
  val foo = new FooBad()

  val thread1 = new MyThread(foo, "first")
  val thread2 = new MyThread(foo, "second")
  val thread3 = new MyThread(foo, "third")

  thread3.start()
  thread2.start()
  thread1.start()
}
