package Q1_05_One_Away

object QuestionB {

  def oneEditAway(first: String, second: String): Boolean = {
    if (Math.abs(first.length - second.length) > 1) {
      return false
    }

    val s1 = if (first.length < second.length) first else second
    val s2 = if (first.length < second.length) second else first

    var index1 = 0
    var index2 = 0
    var foundDifference = false
    while (index2 < s2.length && index1 < s1.length) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (foundDifference) return false
        foundDifference = true
        if (s1.length == s2.length) {
          index1 += 1
        }
      } else {
        index1 += 1
      }
      index2 += 1
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val a = "palee"
    val b = "pale"
    val isOneEdit1 = oneEditAway(a, b)
    println(s"$a, $b: $isOneEdit1")

    val c = "pale"
    val d = "pkle"
    val isOneEdit2 = oneEditAway(c, d)
    println(s"$c, $d: $isOneEdit2")
  }

}
