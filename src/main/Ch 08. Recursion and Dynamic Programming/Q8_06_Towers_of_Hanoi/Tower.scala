package Q8_06_Towers_of_Hanoi

import scala.collection.mutable.Stack

class Tower(val name: String) {
  private val disks = Stack[Int]()

  def add(d: Int): Unit = {
    if (disks.nonEmpty && disks.top <= d) {
      println(s"Error placing disk $d")
    } else {
      disks.push(d)
    }
  }

  def moveTopTo(t: Tower): Unit = {
    val top = disks.pop()
    t.add(top)
  }

  def print(): Unit = {
    println(s"Contents of Tower $name: ${disks.mkString(", ")}")
  }

  def moveDisks(quantity: Int, destination: Tower, buffer: Tower): Unit = {
    if (quantity <= 0) return

    moveDisks(quantity - 1, buffer, destination)
    println(s"Move ${disks.top} from $name to ${destination.name}")
    moveTopTo(destination)
    buffer.moveDisks(quantity - 1, destination, this)
  }
}
