package Q16_18_Pattern_Matcher

object QuestionC {

  def buildFromPattern(pattern: String, main: String, alt: String): String = {
    val first = pattern.head
    pattern.map {
      case `first` => main
      case _ => alt
    }.mkString
  }

  def countOf(pattern: String, c: Char): Int = {
    pattern.count(_ == c)
  }

  def doesMatch(pattern: String, value: String): Boolean = {
    if (pattern.isEmpty) return value.isEmpty

    val mainChar = pattern.head
    val altChar = if (mainChar == 'a') 'b' else 'a'
    val size = value.length

    val countOfMain = countOf(pattern, mainChar)
    val countOfAlt = pattern.length - countOfMain
    val firstAlt = pattern.indexOf(altChar)
    val maxMainSize = size / countOfMain

    for (mainSize <- 0 to maxMainSize) {
      val remainingLength = size - mainSize * countOfMain
      val first = value.substring(0, mainSize)
      if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
        val altIndex = firstAlt * mainSize
        val altSize = if (countOfAlt == 0) 0 else remainingLength / countOfAlt
        val second = if (countOfAlt == 0) "" else value.substring(altIndex, altSize + altIndex)

        val candidate = buildFromPattern(pattern, first, second)

        if (candidate == value) {
          println(s"$first, $second")
          return true
        }
      }
    }
    false
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
