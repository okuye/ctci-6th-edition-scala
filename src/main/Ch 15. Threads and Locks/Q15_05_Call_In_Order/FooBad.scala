package Q15_05_Call_In_Order

import java.util.concurrent.locks.ReentrantLock

class FooBad {
  val pauseTime: Int = 1000
  val lock1: ReentrantLock = new ReentrantLock()
  val lock2: ReentrantLock = new ReentrantLock()

  lock1.lock()
  lock2.lock()

  def first(): Unit = {
    try {
      println("Started Executing 1")
      Thread.sleep(pauseTime)
      println("Finished Executing 1")
      lock1.unlock()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def second(): Unit = {
    try {
      lock1.lock()
      lock1.unlock()
      println("Started Executing 2")
      Thread.sleep(pauseTime)
      println("Finished Executing 2")
      lock2.unlock()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def third(): Unit = {
    try {
      lock2.lock()
      lock2.unlock()
      println("Started Executing 3")
      Thread.sleep(pauseTime)
      println("Finished Executing 3")
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
