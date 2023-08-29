package Q16_18_Pattern_Matcher

object QuestionB {

  def formStringFromPattern(pattern: String, first: String, second: String): Option[String] = {
    if (pattern.isEmpty) return None

    val firstChar = pattern.head
    val result = pattern.map {
      case `firstChar` => first
      case _ => second
    }.mkString

    Some(result)
  }

  def countOf(pattern: String, ch: Char): Int = pattern.count(_ == ch)

  def canonical(pattern: String): String = {
    if (pattern.head == 'a') pattern
    else pattern.map {
      case 'a' => 'b'
      case 'b' => 'a'
    }
  }

  def doesMatch(pattern: String, value: String): Boolean = {
    if (pattern.isEmpty) return value.isEmpty

    val canonicalPattern = canonical(pattern)
    val countOfAs = countOf(canonicalPattern, 'a')
    val countOfBs = canonicalPattern.length - countOfAs
    val firstB = canonicalPattern.indexOf('b')

    for (aSize <- 0 to value.length / countOfAs) {
      val remainingLength = value.length - aSize * countOfAs
      val first = value.substring(0, aSize)
      if (countOfBs == 0 || remainingLength % countOfBs == 0) {
        val bIndex = firstB * aSize
        val bSize = if (countOfBs == 0) 0 else remainingLength / countOfBs
        val second = if (countOfBs == 0) "" else value.substring(bIndex, bSize + bIndex)

        formStringFromPattern(canonicalPattern, first, second) match {
          case Some(candidate) if candidate == value =>
            println(s"$first, $second")
            return true
          case _ =>
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
