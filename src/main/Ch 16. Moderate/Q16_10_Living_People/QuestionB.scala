package Q16_10_Living_People

import scala.util.Random

object QuestionB {

  def maxAliveYear(people: Array[Person], min: Int, max: Int): Int = {
    val years = createYearMap(people, min, max)
    val best = getMaxIndex(years)

    best + min
  }

  def createYearMap(people: Array[Person], min: Int, max: Int): Array[Int] = {
    val years = Array.fill(max - min + 1)(0)
    for (person <- people) {
      val left = person.birth - min
      val right = person.death - min
      incrementRange(years, left, right)
    }
    years
  }

  def incrementRange(values: Array[Int], left: Int, right: Int): Unit = {
    for (i <- left to right) {
      values(i) += 1
    }
  }

  def getMaxIndex(values: Array[Int]): Int = {
    values.zipWithIndex.maxBy(_._1)._2
  }

  def main(args: Array[String]): Unit = {
    val n = 3
    val first = 1900
    val last = 2000
    val random = new Random()
    val people = Array.ofDim[Person](n)

    for (i <- 0 until n) {
      val birth = first + random.nextInt(last - first)
      val death = birth + random.nextInt(last - birth)
      people(i) = new Person(birth, death)
      println(s"$birth, $death")
    }
    val year = maxAliveYear(people, first, last)
    println(year)
  }
}
