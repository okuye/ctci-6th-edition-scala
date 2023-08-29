package Q17_05_Letters_and_Numbers

object QuestionA {
  def extractSubarray(array: Array[Char], start: Int, end: Int): Array[Char] = {
    if (start > end) return Array.emptyCharArray
    array.slice(start, end + 1)
  }

  def hasEqualLettersNumbers(array: Array[Char], start: Int, end: Int): Boolean = {
    var counter = 0
    for (i <- start to end) {
      if (array(i).isLetter) counter += 1
      else if (array(i).isDigit) counter -= 1
    }
    counter == 0
  }

  def findLongestSubarray(array: Array[Char]): Array[Char] = {
    for (len <- array.length until 1 by -1) {
      for (i <- 0 to array.length - len) {
        if (hasEqualLettersNumbers(array, i, i + len - 1)) {
          return extractSubarray(array, i, i + len - 1)
        }
      }
    }
    Array.emptyCharArray
  }

  def main(args: Array[String]): Unit = {
    val b = '1'
    val a = 'a'
    val array = Array(a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a)
    array.foreach(ch => print(s"$ch "))
    println()

    val max = findLongestSubarray(array)
    println(max.length)
    max.foreach(ch => print(s"$ch "))
    println(s"\nIs Valid? ${hasEqualLettersNumbers(max, 0, max.length - 1)}")
  }
}
