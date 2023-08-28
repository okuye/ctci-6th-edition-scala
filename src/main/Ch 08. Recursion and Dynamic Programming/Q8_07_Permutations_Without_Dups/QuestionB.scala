package Q8_07_Permutations_Without_Dups

object QuestionB {

  def getPerms(remainder: String): List[String] = {
    val len = remainder.length

    if (len == 0) return List("")

    for {
      i <- 0 until len
      before = remainder.substring(0, i)
      after = remainder.substring(i + 1)
      partial <- getPerms(before + after)
    } yield remainder.charAt(i) + partial
  }

  def main(args: Array[String]): Unit = {
    val list = getPerms("abc")
    println(s"There are ${list.size} permutations.")
    list.foreach(println)
  }
}
