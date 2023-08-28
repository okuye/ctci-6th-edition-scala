package Q1_04_Palindrome_Permutation

object QuestionA {

  def checkMaxOneOdd(table: Array[Int]): Boolean = {
    var foundOdd = false
    for (count <- table) {
      if (count % 2 == 1) {
        if (foundOdd) {
          return false
        }
        foundOdd = true
      }
    }
    true
  }

  def isPermutationOfPalindrome(phrase: String): Boolean = {
    val table = Common.buildCharFrequencyTable(phrase)
    checkMaxOneOdd(table)
  }

  def main(args: Array[String]): Unit = {
    val pali = "Rats live on no evil star"
    println(isPermutationOfPalindrome(pali))
  }

}
