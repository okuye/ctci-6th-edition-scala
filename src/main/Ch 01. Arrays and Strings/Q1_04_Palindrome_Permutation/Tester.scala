package Q1_04_Palindrome_Permutation

object Tester {

  def main(args: Array[String]): Unit = {
    val strings = Array(
      "Rats live on no evil star",
      "A man, a plan, a canal, panama",
      "Lleve",
      "Tacotac",
      "asda"
    )

    for (s <- strings) {
      val a = QuestionA.isPermutationOfPalindrome(s)
      val b = QuestionB.isPermutationOfPalindrome(s)
      val c = QuestionC.isPermutationOfPalindrome(s)
      println(s)
      if (a == b && b == c) {
        println("Agree: " + a)
      } else {
        println(s"Disagree: $a, $b, $c")
      }
      println()
    }
  }

}
