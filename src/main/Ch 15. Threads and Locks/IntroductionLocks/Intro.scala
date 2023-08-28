package IntroductionLocks

object Intro extends App {
  val noLockATM = new NoLockATM()
  val lockedATM = new LockedATM()
  val thread1 = new MyClass(noLockATM, lockedATM)
  val thread2 = new MyClass(noLockATM, lockedATM)

  thread1.start()
  thread2.start()

  try {
    Thread.sleep(1000)
  } catch {
    case e: InterruptedException => e.printStackTrace()
  }

  thread1.waitUntilDone()
  thread2.waitUntilDone()

  println(s"NoLock ATM: ${noLockATM.getBalance}")
  println(s"Locked ATM: ${lockedATM.getBalance}")
  val v = thread1.delta + thread2.delta + 100
  println(s"Should Be: $v")
  println("Program terminating.")
}
