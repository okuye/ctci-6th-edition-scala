package Q17_21_Volume_of_Histogram

object Tester {
  def main(args: Array[String]): Unit = {
    val tests = Array(
      Array("6 1 8 1 2 1 5", "16"),
      Array("5 1 2 1 8", "11"),
      Array("15 12 20 16 17 25", "10"),
      Array("28 25 26", "1"),
      Array("28 25 28", "3"),
      Array("22", "0"),
      Array("22 22", "0"),
      Array("0 0 4 0 0 6 0 0 3 0 8 0 2 0 5 2 0 3 0 0", "46")
    )

    for (test <- tests) {
      val input = test(0)
      val output = test(1)
      val inputStringArray = input.split(" ")
      val histogram = inputStringArray.map(_.toInt)
      val targetVolume = output.toInt

      val volumeA = QuestionA.computeHistogramVolume(histogram)
      val volumeB = QuestionB.computeHistogramVolume(histogram)
      val volumeC = QuestionC.computeHistogramVolume(histogram)
      if (volumeA != targetVolume || volumeB != targetVolume || volumeC != targetVolume) {
        println(s"FAILURE: $input -> wanted $output but got ($volumeA, $volumeB, $volumeC)")
      } else {
        println(s"SUCCESS: $input -> $targetVolume")
      }
    }
  }
}

