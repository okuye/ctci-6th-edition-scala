package Q1_02_Check_Permutation

object QuestionB {

  def permutation(s: String, t: String): Boolean = {
    if (s.length != t.length) return false // Permutations must be same length

    val letters = Array.ofDim[Int](128) // Assumption: ASCII
    for (i <- 0 until s.length) {
      letters(s.charAt(i)) += 1
    }

    for (i <- 0 until t.length) {
      letters(t.charAt(i)) -= 1
      if (letters(t.charAt(i)) < 0) {
        return false
      }
    }

    true // letters array has no negative values, and therefore no positive values either
  }

  def main(args: Array[String]): Unit = {
    val pairs = Array(
      Array("apple", "papel"),
      Array("carrot", "tarroc"),
      Array("hello", "llloh")
    )
    for (pair <- pairs) {
      val word1 = pair(0)
      val word2 = pair(1)
      val anagram = permutation(word1, word2)
      println(s"$word1, $word2: $anagram")
    }
  }
}
