package Q1_04_Palindrome_Permutation

object QuestionC {

  def toggle(bitVector: Int, index: Int): Int = {
    if (index < 0) return bitVector

    val mask = 1 << index
    if ((bitVector & mask) == 0) {
      bitVector | mask
    } else {
      bitVector & ~mask
    }
  }

  def createBitVector(phrase: String): Int = {
    var bitVector = 0
    for (c <- phrase.toCharArray) {
      val x = Common.getCharNumber(c)
      bitVector = toggle(bitVector, x)
    }
    bitVector
  }

  def checkAtMostOneBitSet(bitVector: Int): Boolean = {
    (bitVector & (bitVector - 1)) == 0
  }

  def isPermutationOfPalindrome(phrase: String): Boolean = {
    val bitVector = createBitVector(phrase)
    checkAtMostOneBitSet(bitVector)
  }

  def main(args: Array[String]): Unit = {
    val pali = "Rats live on no evil star"
    println(isPermutationOfPalindrome(pali))
  }

}
