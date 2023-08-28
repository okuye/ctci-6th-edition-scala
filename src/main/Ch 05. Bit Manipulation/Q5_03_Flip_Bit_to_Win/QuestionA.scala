package Q5_03_Flip_Bit_to_Win

object QuestionA {

  val SEQUENCE_LENGTH = 32

  def getBit(num: Int, i: Int): Boolean = {
    (num & (1 << i)) != 0
  }

  def longestSequence(n: Int): Int = {
    var maxSeq = 0
    for (i <- 0 until SEQUENCE_LENGTH) {
      maxSeq = Math.max(maxSeq, longestSequenceOf1s(n, i))
    }
    maxSeq
  }

  def longestSequenceOf1s(n: Int, indexToIgnore: Int): Int = {
    var max = 0
    var counter = 0
    for (i <- 0 until SEQUENCE_LENGTH) {
      if (i == indexToIgnore || getBit(n, i)) {
        counter += 1
        max = Math.max(counter, max)
      } else {
        counter = 0
      }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    val original_number = Int.MaxValue
    val new_number = longestSequence(original_number)

    println(original_number.toBinaryString)
    println(new_number)
  }
}
