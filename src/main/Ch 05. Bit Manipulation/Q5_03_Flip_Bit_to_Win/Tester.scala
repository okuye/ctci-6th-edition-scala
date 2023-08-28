package Q5_03_Flip_Bit_to_Win

object Tester {

  def checkRange(start: Int, range: Int): Boolean = {
    for (i <- 0 until range) {
      val value = start + i
      val seqA = QuestionA.longestSequence(value)
      val seqB = QuestionB.longestSequence(value)
      val seqC = QuestionC.longestSequence(value)
      val seqD = QuestionC.longestSequence(value)

      if (seqA != seqB || seqB != seqC || seqC != seqD) {
        println(s"FAILURE on value $value")
        println(value.toBinaryString)
        println(s"A: $seqA")
        println(s"B: $seqB")
        println(s"C: $seqC")
        println(s"D: $seqD")
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val ranges = Array(
      Array(Int.MinValue, 1000),
      Array(Int.MaxValue - 2333, 5333),
      Array(-10000, 20000)
    )

    for (range <- ranges) {
      if (!checkRange(range(0), range(1))) {
        println("ERROR")
      } else {
        val end = range(0) + range(1)
        println(s"SUCCESS: ${range(0)} -> $end")
      }
    }
  }
}
