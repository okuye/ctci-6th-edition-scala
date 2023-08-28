package Q15_03_Dining_Philosophers.QuestionB

import CtCILibrary.AssortedMethods

class Philosopher(i: Int, left: Chopstick, right: Chopstick) extends Thread {
  private val maxPause = 100
  private val bites = 10

  private val index = i
  private val (lower, higher) = if (left.getNumber < right.getNumber) {
    (left, right)
  } else {
    (right, left)
  }

  override def run(): Unit = {
    for (_ <- 0 until bites) {
      eat()
    }
  }

  def eat(): Unit = {
    println(s"Philosopher $index: start eating")
    pickUp()
    chew()
    putDown()
    println(s"Philosopher $index: done eating")
  }

  def pickUp(): Unit = {
    pause()
    lower.pickUp()
    pause()
    higher.pickUp()
    pause()
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
    higher.putDown()
    lower.putDown()
  }
}
