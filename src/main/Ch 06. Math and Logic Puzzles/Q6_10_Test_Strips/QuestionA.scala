package Q6_10_Test_Strips

import scala.collection.mutable
import scala.util.Random

object QuestionA {
  def findPoisonedBottle(
      bottles: mutable.Buffer[Bottle],
      strips: mutable.Buffer[TestStrip]
  ): Int = {
    var today = 0

    while (bottles.size > 1 && strips.nonEmpty) {
      runTestSet(bottles, strips, today)
      today += TestStrip.DAYS_FOR_RESULT

      var found = false
      for (strip <- strips if !found && strip.isPositiveOnDay(today)) {
        strip.getLastWeeksBottles(today).foreach(bottles --= _)
        strips -= strip
        found = true
      }
    }

    if (bottles.size == 1) {
      println(s"Suspected bottle is ${bottles.head.id} on day $today")
      bottles.head.id
    } else {
      -1
    }
  }

  def runTestSet(
      bottles: mutable.Buffer[Bottle],
      strips: mutable.Buffer[TestStrip],
      day: Int
  ): Unit = {
    bottles.zipWithIndex.foreach { case (bottle, index) =>
      val strip = strips(index % strips.size)
      strip.addDropOnDay(day, bottle)
    }
  }

  def createBottles(nBottles: Int, poisoned: Int): mutable.Buffer[Bottle] = {
    val bottles = (0 until nBottles).map(new Bottle(_)).toBuffer

    val poisonedIndex =
      if (poisoned == -1) Random.nextInt(nBottles) else poisoned
    bottles(poisonedIndex).setAsPoisoned()

    println(s"Added poison to bottle $poisonedIndex")
    bottles
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
