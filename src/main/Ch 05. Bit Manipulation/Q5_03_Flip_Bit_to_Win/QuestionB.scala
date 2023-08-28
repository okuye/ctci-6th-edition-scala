package Q5_03_Flip_Bit_to_Win

object QuestionB {

  def longestSequence(n: Int): Int = {
    if (n == -1) return Integer.BYTES * 8
    val sequences = getAlternatingSequences(n)
    findLongestSequence(sequences)
  }

  def getAlternatingSequences(n: Int): List[Int] = {
    var sequences = List[Int]()
    var searchingFor = 0
    var counter = 0
    var mutableN = n

    for (_ <- 0 until Integer.BYTES * 8) {
      if ((mutableN & 1) != searchingFor) {
        sequences = sequences :+ counter
        searchingFor = mutableN & 1
        counter = 0
      }
      counter += 1
      mutableN >>>= 1
    }
    sequences :+ counter
  }

  def findLongestSequence(seq: List[Int]): Int = {
    var maxSeq = 1

    for (i <- seq.indices by 2) {
      val zerosSeq = seq(i)
      val onesSeqPrev = if (i - 1 >= 0) seq(i - 1) else 0
      val onesSeqNext = if (i + 1 < seq.length) seq(i + 1) else 0

      val thisSeq = zerosSeq match {
        case 1 => onesSeqNext + 1 + onesSeqPrev
        case _ if zerosSeq > 1 => 1 + Math.max(onesSeqPrev, onesSeqNext)
        case 0 => Math.max(onesSeqPrev, onesSeqNext)
      }

      maxSeq = Math.max(thisSeq, maxSeq)
    }

    maxSeq
  }

  def main(args: Array[String]): Unit = {
    val original_number = 1775
    val new_number = longestSequence(original_number)

    println(original_number.toBinaryString)
    println(new_number)
  }
}
