package IntroductionLocks

import java.util.concurrent.locks.{Lock, ReentrantLock}

class LockedATM {
  private val lock: Lock = new ReentrantLock()
  private var balance: Int = 100

  def withdraw(value: Int): Int = {
    lock.lock()
    var temp = balance
    try {
      Thread.sleep(100)
      temp -= value
      Thread.sleep(100)
      balance = temp
    } catch {
      case _: InterruptedException => // handle the exception if necessary
    } finally {
      lock.unlock()
    }
    temp
  }

  def deposit(value: Int): Int = {
    lock.lock()
    var temp = balance
    try {
      Thread.sleep(100)
      temp += value
      Thread.sleep(100)
      balance = temp
    } catch {
      case _: InterruptedException => // handle the exception if necessary
    } finally {
      lock.unlock()
    }
    temp
  }

  def getBalance: Int = balance
}
