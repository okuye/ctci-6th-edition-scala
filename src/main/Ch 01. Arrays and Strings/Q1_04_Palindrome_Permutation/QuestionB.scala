package Q1_04_Palindrome_Permutation

object QuestionB {

  def isPermutationOfPalindrome(phrase: String): Boolean = {
    var countOdd = 0
    val table = new Array[Int](Character.getNumericValue('z') - Character.getNumericValue('a') + 1)
    for (c <- phrase.toCharArray) {
      val x = Common.getCharNumber(c)
      if (x != -1) {
        table(x) += 1

        if (table(x) % 2 == 1) {
          countOdd += 1
        } else {
          countOdd -= 1
        }
      }
    }
    countOdd <= 1
  }

  def main(args: Array[String]): Unit = {
    val pali = "Ratzs live on no evil starz"
    println(isPermutationOfPalindrome(pali))
    val pali2 = "Zeus was deified, saw Suez"
    println(isPermutationOfPalindrome(pali2))
  }

}
