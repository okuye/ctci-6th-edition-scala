package Q17_06_Count_of_2s

object QuestionBrute {

  def numberOf2s(n: Int): Int = {
    var count = 0
    var number = n
    while (number > 0) {
      if (number % 10 == 2) {
        count += 1
      }
      number /= 10
    }
    count
  }

  def numberOf2sInRange(n: Int): Int = {
    (2 to n).map(i => numberOf2s(i)).sum
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 1000) {
      val v = numberOf2sInRange(i)
      println(s"Between 0 and $i: $v")
    }
  }
}
