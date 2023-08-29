package Q16_10_Living_People

import scala.util.Random

object QuestionA {

  def maxAliveYear(people: Array[Person], min: Int, max: Int): Int = {
    var maxAlive = 0
    var maxAliveYear = min

    for (year <- min to max) {
      var alive = 0
      for (person <- people) {
        if (person.birth <= year && year <= person.death) {
          alive += 1
        }
      }
      if (alive > maxAlive) {
        maxAlive = alive
        maxAliveYear = year
      }
    }

    maxAliveYear
  }

  def main(args: Array[String]): Unit = {
    val n = 10000
    val first = 0
    val last = 200000
    val random = new Random()
    val people = Array.ofDim[Person](n)

    for (i <- 0 until n) {
      val birth = first + random.nextInt(last - first)
      val death = birth + random.nextInt(last - birth)
      people(i) = new Person(birth, death)
    }

    println(n)
    people.foreach(p => println(p.birth))
    println(n)
    people.foreach(p => println(p.death))

    val year = maxAliveYear(people, first, last)
    println(year)
  }
}
