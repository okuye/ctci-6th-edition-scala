package Q15_03_Dining_Philosophers.QuestionA

import CtCILibrary.AssortedMethods

class Philosopher(i: Int, private val left: Chopstick, private val right: Chopstick) extends Thread {
  private val maxPause = 100
  private val bites = 10
  private val index = i

  def eat(): Unit = {
    println(s"Philosopher $index: start eating")
    if (pickUp()) {
      chew()
      putDown()
      println(s"Philosopher $index: done eating")
    } else {
      println(s"Philosopher $index: gave up on eating")
    }
  }

  def pickUp(): Boolean = {
    pause()
    if (!left.pickUp()) {
      return false
    }
    pause()
    if (!right.pickUp()) {
      left.putDown()
      return false
    }
    pause()
    true
  }

  def chew(): Unit = {
    println(s"Philosopher $index: eating")
    pause()
  }

  def pause(): Unit = {
    try {
      val pause = AssortedMethods.randomIntInRange(0, maxPause)
      Thread.sleep(pause)
    } catch {
      case e: InterruptedException => e.printStackTrace()
    }
  }

  def putDown(): Unit = {
    right.putDown()
    left.putDown()
  }

  override def run(): Unit = {
    for (_ <- 0 until bites) {
      eat()
    }
  }
}
