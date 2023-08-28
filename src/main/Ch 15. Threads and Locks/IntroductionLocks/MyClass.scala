package IntroductionLocks

import java.util.concurrent.locks.{Lock, ReentrantLock}
import CtCILibrary.AssortedMethods

class MyClass(atm1: NoLockATM, atm2: LockedATM) extends Thread {
  private val noLockATM = atm1
  private val lockedATM = atm2
  var delta: Int = 0

  private val completionLock: Lock = new ReentrantLock()

  override def run(): Unit = {
    completionLock.lock()
    val operations = AssortedMethods.randomArray(20, -50, 50)
    for (op <- operations) {
      delta += op
      if (op < 0) {
        val value = -op
        noLockATM.withdraw(value)
        lockedATM.withdraw(value)
      } else {
        noLockATM.deposit(op)
        lockedATM.deposit(op)
      }
    }
    completionLock.unlock()
  }

  def waitUntilDone(): Unit = {
    completionLock.lock()
    completionLock.unlock()
  }
}
