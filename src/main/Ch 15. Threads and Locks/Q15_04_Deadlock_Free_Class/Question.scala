package Q15_04_Deadlock_Free_Class

object Question extends App {
  val res1 = Array(1, 2, 3, 4)
  val res2 = Array(1, 5, 4, 1)
  val res3 = Array(1, 4, 5)

  LockFactory.initialize(10)

  val lf = LockFactory.getInstance
  println(lf.declare(1, res1))
  println(lf.declare(2, res2))
  println(lf.declare(3, res3))

  println(lf.getLock(1, 1))
  println(lf.getLock(1, 2))
  println(lf.getLock(2, 4))
}
