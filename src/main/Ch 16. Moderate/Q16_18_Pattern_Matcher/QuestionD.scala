package Q16_18_Pattern_Matcher

object QuestionD {

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
      if (countOfAlt == 0 || remainingLength % countOfAlt == 0) {
        val altIndex = firstAlt * mainSize
        val altSize = if (countOfAlt == 0) 0 else remainingLength / countOfAlt
        if (matches(pattern, value, mainSize, altSize, altIndex)) {
          return true
        }
      }
    }
    false
  }

  def matches(pattern: String, value: String, mainSize: Int, altSize: Int, firstAlt: Int): Boolean = {
    var stringIndex = mainSize
    for (i <- 1 until pattern.length) {
      val size = if (pattern(i) == pattern.head) mainSize else altSize
      val offset = if (pattern(i) == pattern.head) 0 else firstAlt
      if (!isEqual(value, offset, stringIndex, size)) {
        return false
      }
      stringIndex += size
    }
    true
  }

  def isEqual(s1: String, offset1: Int, offset2: Int, size: Int): Boolean = {
    for (i <- 0 until size) {
      if (s1(offset1 + i) != s1(offset2 + i)) {
        return false
      }
    }
    true
  }

  def countOf(pattern: String, c: Char): Int = {
    pattern.count(_ == c)
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
