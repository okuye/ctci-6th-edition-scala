package Q1_02_Check_Permutation

object QuestionA {

  def sort(s: String): String = {
    val content = s.toCharArray
    scala.util.Sorting.quickSort(content)
    new String(content)
  }

  def permutation(s: String, t: String): Boolean = {
    sort(s) == sort(t)
  }

  def main(args: Array[String]): Unit = {
    val pairs = Array(Array("apple", "papel"), Array("carrot", "tarroc"), Array("hello", "llloh"))
    for (pair <- pairs) {
      val word1 = pair(0)
      val word2 = pair(1)
      val anagram = permutation(word1, word2)
      println(s"$word1, $word2: $anagram")
    }
  }
}
