package Q1_05_One_Away

object QuestionA {

  def oneEditReplace(s1: String, s2: String): Boolean = {
    var foundDifference = false
    for (i <- 0 until s1.length) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (foundDifference) {
          return false
        }
        foundDifference = true
      }
    }
    true
  }

  def oneEditInsert(s1: String, s2: String): Boolean = {
    var index1 = 0
    var index2 = 0
    while (index2 < s2.length && index1 < s1.length) {
      if (s1.charAt(index1) != s2.charAt(index2)) {
        if (index1 != index2) {
          return false
        }
        index2 += 1
      } else {
        index1 += 1
        index2 += 1
      }
    }
    true
  }

  def oneEditAway(first: String, second: String): Boolean = {
    if (first.length == second.length) {
      oneEditReplace(first, second)
    } else if (first.length + 1 == second.length) {
      oneEditInsert(first, second)
    } else if (first.length - 1 == second.length) {
      oneEditInsert(second, first)
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val a = "pse"
    val b = "pale"
    val isOneEdit = oneEditAway(a, b)
    println(s"$a, $b: $isOneEdit")
  }

}
