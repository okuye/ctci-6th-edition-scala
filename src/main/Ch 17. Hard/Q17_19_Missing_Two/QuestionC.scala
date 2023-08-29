package Q17_19_Missing_Two

object QuestionC {
  def squareSumToN(n: Int, power: Int): Int = {
    var sum = 0
    for (i <- 1 to n) {
      sum += math.pow(i, power).toInt
    }
    sum
  }

  def solveEquation(r1: Int, r2: Int): Array[Int] = {
    val a = 2
    val b = -2 * r1
    val c = r1 * r1 - r2

    val part1 = -1 * b
    val part2 = math.sqrt(b * b - 4 * a * c)
    val part3 = 2 * a

    val solutionX = ((part1 + part2) / part3).toInt
    val solutionY = r1 - solutionX

    val solutionX2 = ((part1 - part2) / part3).toInt
    val solutionY2 = r1 - solutionX2

    println(s"Alternate: ($solutionX2, $solutionY2)")

    Array(solutionX, solutionY)
  }

  def missingTwo(array: Array[Int]): Array[Int] = {
    val max_value = array.length + 2
    val rem_square = squareSumToN(max_value, 2)
    val rem_one = max_value * (max_value + 1) / 2

    for (i <- array.indices) {
      rem_square -= array(i) * array(i)
      rem_one -= array(i)
    }

    solveEquation(rem_one, rem_square)
  }

  def main(args: Array[String]): Unit = {
    val max = 100
    for (x <- 1 until max) {
      for (y <- 1 until max) {
        if (x != y) {
          val len = max - 2
          var count = 0
          val array = new Array[Int](len)
          for (i <- 1 to max) {
            if (i != x && i != y) {
              array(count) = i
              count += 1
            }
          }
          val solution = missingTwo(array)

          if (
            (solution(0) == x && solution(1) == y) ||
            (solution(1) == x && solution(0) == y)
          ) {
            println(s"Success: ${solution(0)}, ${solution(1)}")
          } else {
            println(s"Error: $x, $y | ${solution(0)}, ${solution(1)}")
          }
        }
      }
    }
  }
}
