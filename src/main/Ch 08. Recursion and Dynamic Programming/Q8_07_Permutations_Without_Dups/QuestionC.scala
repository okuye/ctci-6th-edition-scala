package Q8_07_Permutations_Without_Dups

object QuestionC {

  def getPerms(prefix: String, remainder: String, result: scala.collection.mutable.ListBuffer[String]): Unit = {
    if (remainder.isEmpty) {
      result += prefix
    }
    for (i <- remainder.indices) {
      val before = remainder.substring(0, i)
      val after = remainder.substring(i + 1)
      val c = remainder.charAt(i)
      getPerms(prefix + c, before + after, result)
    }
  }

  def getPerms(str: String): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    getPerms("", str, result)
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val list = getPerms("abc")
    println(s"There are ${list.size} permutations.")
    list.foreach(println)
  }
}
