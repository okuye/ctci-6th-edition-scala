package Q16_10_Living_People

import scala.util.Random
import scala.util.Sorting

object QuestionC {

  def maxAliveYear(people: Array[Person], min: Int, max: Int): Int = {
    val births = getSortedYears(people, copyBirthYear = true)
    val deaths = getSortedYears(people, copyBirthYear = false)

    var birthIndex = 0
    var deathIndex = 0
    var currentlyAlive = 0
    var maxAlive = 0
    var maxAliveYear = min

    while (birthIndex < births.length) {
      if (births(birthIndex) <= deaths(deathIndex)) {
        currentlyAlive += 1
        if (currentlyAlive > maxAlive) {
          maxAlive = currentlyAlive
          maxAliveYear = births(birthIndex)
        }
        birthIndex += 1
      } else {
        currentlyAlive -= 1
        deathIndex += 1
      }
    }

    maxAliveYear
  }

  def getSortedYears(people: Array[Person], copyBirthYear: Boolean): Array[Int] = {
    val years = new Array[Int](people.length)
    for (i <- people.indices) {
      years(i) = if (copyBirthYear) people(i).birth else people(i).death
    }
    Sorting.quickSort(years)
    years
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
