package Q6_10_Test_Strips

import scala.collection.mutable

object QuestionC {
  def createBottles(nBottles: Int, poisoned: Int): mutable.Buffer[Bottle] = {
    val bottles = (0 until nBottles).map(new Bottle(_)).toBuffer

    val poisonedIndex = if (poisoned == -1) scala.util.Random.nextInt(nBottles) else poisoned
    bottles(poisonedIndex).setAsPoisoned()

    println(s"Added poison to bottle $poisonedIndex")
    bottles
  }

  def findPoisonedBottle(bottles: mutable.Buffer[Bottle], strips: mutable.Buffer[TestStrip]): Int = {
    runTests(bottles, strips)
    val positive = getPositiveOnDay(strips, 7)
    setBits(positive)
  }

  def runTests(bottles: mutable.Buffer[Bottle], testStrips: mutable.Buffer[TestStrip]): Unit = {
    bottles.foreach { bottle =>
      var id = bottle.id
      var bitIndex = 0
      while (id > 0) {
        if ((id & 1) == 1) {
          testStrips(bitIndex).addDropOnDay(0, bottle)
        }
        bitIndex += 1
        id >>= 1
      }
    }
  }

  def getPositiveOnDay(testStrips: mutable.Buffer[TestStrip], day: Int): mutable.Buffer[Int] = {
    testStrips.filter(_.isPositiveOnDay(day)).map(_.id)
  }

  def setBits(positive: mutable.Buffer[Int]): Int = {
    positive.foldLeft(0)((id, bitIndex) => id | (1 << bitIndex))
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
