package Q16_10_Living_People

import scala.util.Random

object Tester {

  def main(args: Array[String]): Unit = {
    val n = 100
    val first = 1900
    val last = 2000

    val random = new Random()
    val people = new Array[Person](n + 1)
    for (i <- 0 until n) {
      val birth = first + random.nextInt(last - first)
      val death = birth + random.nextInt(last - birth)
      people(i) = new Person(birth, death)
      // println(s"$birth, $death")
    }
    people(n) = new Person(first, first)

    val yearA = QuestionA.maxAliveYear(people, first, last)
    val yearB = QuestionB.maxAliveYear(people, first, last)
    val yearC = QuestionC.maxAliveYear(people, first, last)
    val yearD = QuestionD.maxAliveYear(people, first, last)
    println(s"A: $yearA")
    println(s"B: $yearB")
    println(s"C: $yearC")
    println(s"D: $yearD")
  }
}
