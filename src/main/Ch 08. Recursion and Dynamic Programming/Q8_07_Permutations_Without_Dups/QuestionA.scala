package Q8_07_Permutations_Without_Dups

object QuestionA {

  def getPerms(str: String): List[String] = {
    if (str == null) return Nil
    if (str.isEmpty) return List("")

    val first = str.head
    val remainder = str.tail
    val words = getPerms(remainder)

    for {
      word <- words
      j <- 0 to word.length
      s = insertCharAt(word, first, j)
    } yield s
  }

  def insertCharAt(word: String, c: Char, i: Int): String = {
    val (start, end) = word.splitAt(i)
    start + c + end
  }

  def main(args: Array[String]): Unit = {
    val list = getPerms("abcde")
    println(s"There are ${list.size} permutations.")
    list.foreach(println)
  }
}
