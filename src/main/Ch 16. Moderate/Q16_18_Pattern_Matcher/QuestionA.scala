package Q16_18_Pattern_Matcher

object QuestionA {

  def doesMatch(pattern: String, value: String): Boolean = {
    if (pattern.isEmpty) return value.isEmpty
    val size = value.length

    for {
      mainSize <- 0 to size
      main = value.substring(0, mainSize)
      altStart <- mainSize to size
      altEnd <- altStart to size
      alt = value.substring(altStart, altEnd)
      cand = buildFromPattern(pattern, main, alt) if cand == value
    } {
      println(s"$main, $alt")
      return true
    }

    false
  }

  def buildFromPattern(pattern: String, main: String, alt: String): String = {
    val firstChar = pattern.head
    pattern.map {
      case `firstChar` => main
      case _ => alt
    }
  }

  def main(args: Array[String]): Unit = {
    val tests = Array(
      Array("ababb", "backbatbackbatbat"),
      Array("abab", "backsbatbackbats"),
      Array("aba", "backsbatbacksbat")
    )
    for (test <- tests) {
      val pattern = test(0)
      val value = test(1)
      println(s"$pattern, $value: ${doesMatch(pattern, value)}")
    }
  }
}
