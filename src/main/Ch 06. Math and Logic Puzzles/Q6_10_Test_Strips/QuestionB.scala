package Q6_10_Test_Strips

import scala.collection.mutable
import scala.util.Random

object QuestionB {
  def createBottles(nBottles: Int, poisoned: Int): mutable.Buffer[Bottle] = {
    val bottles = (0 until nBottles).map(new Bottle(_)).toBuffer

    val poisonedIndex = if (poisoned == -1) Random.nextInt(nBottles) else poisoned
    bottles(poisonedIndex).setAsPoisoned()

    println(s"Added poison to bottle $poisonedIndex")
    bottles
  }

  def findPoisonedBottle(bottles: mutable.Buffer[Bottle], strips: mutable.Buffer[TestStrip]): Int = {
    if (bottles.size > 1000 || strips.size < 10) return -1

    val tests = 4
    val nTestStrips = strips.size

    for (day <- 0 until tests) {
      runTestSet(bottles, strips, day)
    }

    val previousResults = mutable.HashSet[Int]()
    val digits = Array.fill(tests)(-1)
    for (day <- 0 until tests) {
      val resultDay = day + TestStrip.DAYS_FOR_RESULT
      digits(day) = getPositiveOnDay(strips, resultDay, previousResults)
      previousResults += digits(day)
    }

    if (digits(1) == -1) digits(1) = digits(0)
    if (digits(2) == -1) {
      if (digits(3) == -1) {
        digits(2) = if ((digits(0) + 1) % nTestStrips == digits(1)) digits(0) else digits(1)
      } else {
        digits(2) = (digits(3) - 1 + nTestStrips) % nTestStrips
      }
    }

    digits(0) * 100 + digits(1) * 10 + digits(2)
  }

  def runTestSet(bottles: mutable.Buffer[Bottle], strips: mutable.Buffer[TestStrip], day: Int): Unit = {
    if (day > 3) return

    bottles.foreach { bottle =>
      val index = getTestStripIndexForDay(bottle, day, strips.size)
      val testStrip = strips(index)
      testStrip.addDropOnDay(day, bottle)
    }
  }

  def getTestStripIndexForDay(bottle: Bottle, day: Int, nTestStrips: Int): Int = {
    val id = bottle.id
    day match {
      case 0 => id / 100
      case 1 => (id % 100) / 10
      case 2 => id % 10
      case 3 => (id % 10 + 1) % nTestStrips
      case _ => -1
    }
  }

  def getPositiveOnDay(testStrips: mutable.Buffer[TestStrip], day: Int, previousResults: mutable.HashSet[Int]): Int = {
    testStrips.find(strip => strip.isPositiveOnDay(day) && !previousResults.contains(strip.id)).map(_.id).getOrElse(-1)
  }

  def createTestStrips(nTestStrips: Int): mutable.Buffer[TestStrip] = {
    (0 until nTestStrips).map(new TestStrip(_)).toBuffer
  }

  def main(args: Array[String]): Unit = {
    val nBottles = 1000
    val nTestStrips = 10

    for (poisoned <- 0 until nBottles) {
      val bottles = createBottles(nBottles, poisoned)
      val testStrips = createTestStrips(nTestStrips)
      val poisonedId = findPoisonedBottle(bottles, testStrips)
      println(s"Suspected Bottle: $poisonedId")
      if (poisonedId != poisoned) {
        println("ERROR")
      }
    }
  }
}
