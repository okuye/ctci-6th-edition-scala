package Q16_15_Master_Mind

import scala.util.Random

object Tester {

  def estimateBad(g: String, s: String): Result = {
    val guess = g.toCharArray
    val solution = s.toCharArray
    var hits = 0
    for (i <- guess.indices) {
      if (guess(i) == solution(i)) {
        hits += 1
        solution(i) = '0'
        guess(i) = '0'
      }
    }

    var pseudohits = 0

    for (i <- guess.indices) {
      if (guess(i) != '0') {
        for (j <- solution.indices) {
          if (solution(j) != '0') {
            if (solution(j) == guess(i)) {
              pseudohits += 1
              solution(j) = '0'
            }
          }
        }
      }
    }

    Result(hits, pseudohits)
  }

  def randomString(): String = {
    val length = 4
    val str = new Array[Char](length)
    val generator = new Random

    for (i <- 0 until length) {
      val v = generator.nextInt(4)
      val c = Question.letterFromCode(v)
      str(i) = c
    }

    str.mkString
  }

  def test(guess: String, solution: String): Boolean = {
    val res1 = Question.estimate(guess, solution)
    val res2 = estimateBad(guess, solution)
    if (res1.hits == res2.hits && res1.pseudoHits == res2.pseudoHits) {
      true
    } else {
      println(s"FAIL: ($guess, $solution): ${res1.toString} | ${res2.toString}")
      false
    }
  }

  def testRandom(): Boolean = {
    val guess = randomString()
    val solution = randomString()
    test(guess, solution)
  }

  def test(count: Int): Boolean = {
    (0 until count).forall(_ => testRandom())
  }

  def main(args: Array[String]): Unit = {
    test(1000)
  }
}
