package Q15_03_Dining_Philosophers.QuestionB

import java.util.concurrent.locks.{Lock, ReentrantLock}

class Chopstick(n: Int) {
  private val lock: Lock = new ReentrantLock()
  private val number: Int = n

  def pickUp(): Unit = lock.lock()

  def putDown(): Unit = lock.unlock()

  def getNumber: Int = number
}
