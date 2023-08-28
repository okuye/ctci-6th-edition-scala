package Q15_06_Synchronized_Methods

object Question extends App {

  // Part 1 Demo -- same instance
  println("Part 1 Demo with same instance.")
  val fooA = new Foo("ObjectOne")
  val thread1a = new MyThread(fooA, "Dog", "A")
  val thread2a = new MyThread(fooA, "Cat", "A")
  thread1a.start()
  thread2a.start()
  while (thread1a.isAlive || thread2a.isAlive) {}
  println("\n\n")

  // Part 1 Demo -- different instances
  println("Part 1 Demo with different instances.")
  val fooB1 = new Foo("ObjectOne")
  val fooB2 = new Foo("ObjectTwo")
  val thread1b = new MyThread(fooB1, "Dog", "A")
  val thread2b = new MyThread(fooB2, "Cat", "A")
  thread1b.start()
  thread2b.start()
  while (thread1b.isAlive || thread2b.isAlive) {}
  println("\n\n")

  // Part 2 Demo
  println("Part 2 Demo.")
  val fooC = new Foo("ObjectOne")
  val thread1c = new MyThread(fooC, "Dog", "A")
  val thread2c = new MyThread(fooC, "Cat", "B")
  thread1c.start()
  thread2c.start()
}
