package Q17_19_Missing_Two

object QuestionB {
  def missingOne(array: Array[Int]): Int = {
    val max_value = array.length + 1
    val remainder = max_value * (max_value + 1) / 2

    for (i <- array.indices) {
      remainder -= array(i)
    }
    remainder
  }

  def main(args: Array[String]): Unit = {
    val max = 100
    val x = 8
    val len = max - 1
    var count = 0
    val array = new Array[Int](len)
    for (i <- 1 to max) {
      if (i != x) {
        array(count) = i
        count += 1
      }
    }
    println(x)
    val solution = missingOne(array)

    println(solution)
  }
}
