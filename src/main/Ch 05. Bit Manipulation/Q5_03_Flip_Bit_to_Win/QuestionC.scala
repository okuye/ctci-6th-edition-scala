package Q5_03_Flip_Bit_to_Win

object QuestionC {

  val SEQUENCE_LENGTH = 32

  def getMaxSequence(sequences: Array[Int]): Int = {
    sequences(1) match {
      case 1 => sequences(0) + sequences(2) + 1
      case 0 => Math.max(sequences(0), sequences(2))
      case _ => Math.max(sequences(0), sequences(2)) + 1
    }
  }

  def shift(sequences: Array[Int]): Unit = {
    sequences(2) = sequences(1)
    sequences(1) = sequences(0)
    sequences(0) = 0
  }

  def longestSequence(n: Int): Int = {
    var searchingFor = 0
    val sequences = Array(0, 0, 0)
    var maxSequence = 1
    var mutableN = n

    for (_ <- 0 until SEQUENCE_LENGTH) {
      if ((mutableN & 1) != searchingFor) {
        if (searchingFor == 1) {
          maxSequence = Math.max(maxSequence, getMaxSequence(sequences))
        }

        searchingFor = mutableN & 1
        shift(sequences)
      }
      sequences(0) += 1
      mutableN >>>= 1
    }

    if (searchingFor == 0) {
      shift(sequences)
    }
    val finalSequence = getMaxSequence(sequences)
    maxSequence = Math.max(finalSequence, maxSequence)

    maxSequence
  }

  def main(args: Array[String]): Unit = {
    val original_number = Int.MaxValue
    val new_number = longestSequence(original_number)

    println(original_number.toBinaryString)
    println(new_number)
  }
}
