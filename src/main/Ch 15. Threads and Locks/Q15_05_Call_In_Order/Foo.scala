package Q15_05_Call_In_Order

import java.util.concurrent.Semaphore

class Foo {
  val pauseTime: Int = 1000
  val sem1: Semaphore = new Semaphore(1)
  val sem2: Semaphore = new Semaphore(1)

  sem1.acquire()
  sem2.acquire()

  def first(): Unit = {
    try {
      println("Started Executing 1")
      Thread.sleep(pauseTime)
      println("Finished Executing 1")
      sem1.release()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def second(): Unit = {
    try {
      sem1.acquire()
      sem1.release()
      println("Started Executing 2")
      Thread.sleep(pauseTime)
      println("Finished Executing 2")
      sem2.release()
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }

  def third(): Unit = {
    try {
      sem2.acquire()
      sem2.release()
      println("Started Executing 3")
      Thread.sleep(pauseTime)
      println("Finished Executing 3")
    } catch {
      case e: Exception => e.printStackTrace()
    }
  }
}
