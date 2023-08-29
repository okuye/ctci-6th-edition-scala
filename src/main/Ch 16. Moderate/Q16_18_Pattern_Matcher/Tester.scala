package Q16_18_Pattern_Matcher

object Tester {

  def invert(pattern: String): String = {
    pattern.map {
      case 'a' => 'b'
      case 'b' => 'a'
      case other => other
    }.mkString
  }

  def main(args: Array[String]): Unit = {
    val tests = Array(
      Array("ababb", "backbatbackbatbat"),
      Array("ababaa", "batgobatgobatbat"),
      Array("bb", "backback"),
      Array("ababb", "backbatbackbatbat"),
      Array("ababb", "backbatbackbatbackbat"),
      Array("abab", "backsbatbackbats"),
      Array("aba", "backsbatbacksbat")
    )

    for (test <- tests) {
      for (i <- 0 to 1) {
        val pattern = if (i == 0) test(0) else invert(test(0))
        val value = test(1)

        val aMatches = QuestionA.doesMatch(pattern, value)
        val bMatches = QuestionB.doesMatch(pattern, value)
        val cMatches = QuestionC.doesMatch(pattern, value)
        val dMatches = QuestionD.doesMatch(pattern, value)

        if (aMatches != bMatches || aMatches != cMatches || aMatches != dMatches) {
          println("ERROR")
        }
        println(s"$pattern, $value: $aMatches")
        println(s"$pattern, $value: $bMatches")
        println(s"$pattern, $value: $cMatches")
        println(s"$pattern, $value: $dMatches")
      }
    }
  }
}
