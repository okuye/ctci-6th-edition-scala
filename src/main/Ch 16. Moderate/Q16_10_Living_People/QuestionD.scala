package Q16_10_Living_People

import scala.util.Random

object QuestionD {

  def maxAliveYear(people: Array[Person], min: Int, max: Int): Int = {
    val populationDeltas = getPopulationDeltas(people, min, max)
    val maxAliveYear = getMaxAliveYear(populationDeltas)
    maxAliveYear + min
  }

  def getPopulationDeltas(people: Array[Person], min: Int, max: Int): Array[Int] = {
    val populationDeltas = new Array[Int](max - min + 2)
    for (person <- people) {
      val birth = person.birth - min
      populationDeltas(birth) += 1

      val death = person.death - min
      populationDeltas(death + 1) -= 1
    }
    populationDeltas
  }

  def getMaxAliveYear(deltas: Array[Int]): Int = {
    var maxAliveYear = 0
    var maxAlive = 0
    var currentlyAlive = 0
    for (year <- deltas.indices) {
      currentlyAlive += deltas(year)
      if (currentlyAlive > maxAlive) {
        maxAliveYear = year
        maxAlive = currentlyAlive
      }
    }
    maxAliveYear
  }

  def main(args: Array[String]): Unit = {
    val n = 3
    val first = 1900
    val last = 2000
    val random = new Random()
    val people = new Array[Person](n)

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
