package Q6_10_Test_Strips

import scala.collection.mutable

object TestStrip {
  val DAYS_FOR_RESULT = 7
}

class TestStrip(val id: Int) {
  import TestStrip.DAYS_FOR_RESULT

  private val dropsByDay = mutable.Buffer[mutable.Buffer[Bottle]]()

  private def sizeDropsForDay(day: Int): Unit = {
    while (dropsByDay.size <= day) {
      dropsByDay += mutable.Buffer[Bottle]()
    }
  }

  def addDropOnDay(day: Int, bottle: Bottle): Unit = {
    sizeDropsForDay(day)
    val drops = dropsByDay(day)
    drops += bottle
  }

  private def hasPoison(bottles: mutable.Buffer[Bottle]): Boolean = {
    bottles.exists(_.isPoisoned)
  }

  def getLastWeeksBottles(day: Int): Option[mutable.Buffer[Bottle]] = {
    if (day < DAYS_FOR_RESULT) None
    else Some(dropsByDay(day - DAYS_FOR_RESULT))
  }

  def isPositiveOnDay(day: Int): Boolean = {
    val testDay = day - DAYS_FOR_RESULT
    if (testDay < 0 || testDay >= dropsByDay.size) return false
    (0 to testDay).exists(d => hasPoison(dropsByDay(d)))
  }
}
