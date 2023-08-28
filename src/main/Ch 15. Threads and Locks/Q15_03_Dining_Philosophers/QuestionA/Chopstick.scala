package Q15_03_Dining_Philosophers.QuestionA

import java.util.concurrent.locks.{Lock, ReentrantLock}

class Chopstick {
  private val lock: Lock = new ReentrantLock()

  def pickUp(): Boolean = lock.tryLock()

  def putDown(): Unit = lock.unlock()
}
