package Q16_23_Rand7_From_Rand5

object Question {

  def rand7(): Int = {
    Stream.continually {
      val num = 5 * rand5() + rand5()
      if (num < 21) Some(num % 7)
      else None
    }.collectFirst { case Some(value) => value }.get
  }

  def rand5(): Int = (Math.random() * 100).toInt % 5

  def main(args: Array[String]): Unit = {
    val testSize = 1000000
    val arr = Array.fill(7)(0)

    for (_ <- 0 until testSize) {
      arr(rand7()) += 1
    }

    for (i <- arr.indices) {
      val percent = 100.0 * arr(i) / testSize
      println(s"$i appeared $percent% of the time.")
    }
  }
}
