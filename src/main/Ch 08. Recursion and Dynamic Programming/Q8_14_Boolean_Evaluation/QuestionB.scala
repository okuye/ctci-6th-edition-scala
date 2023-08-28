package Q8_14_Boolean_Evaluation

import scala.collection.mutable.HashMap

object QuestionB {
  var count = 0

  def stringToBool(c: String): Boolean = c == "1"

  def countEval(s: String, result: Boolean, memo: HashMap[String, Int]): Int = {
    count += 1
    if (s.isEmpty) return 0
    if (s.length == 1) return if (stringToBool(s) == result) 1 else 0
    if (memo.contains(result + s)) return memo(result + s)

    var ways = 0

    for (i <- 1 until s.length by 2) {
      val c = s.charAt(i)
      val left = s.substring(0, i)
      val right = s.substring(i + 1)
      val leftTrue = countEval(left, true, memo)
      val leftFalse = countEval(left, false, memo)
      val rightTrue = countEval(right, true, memo)
      val rightFalse = countEval(right, false, memo)
      val total = (leftTrue + leftFalse) * (rightTrue + rightFalse)

      var totalTrue = 0
      c match {
        case '^' => totalTrue = leftTrue * rightFalse + leftFalse * rightTrue
        case '&' => totalTrue = leftTrue * rightTrue
        case '|' => totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse
        case _ =>
      }

      val subWays = if (result) totalTrue else total - totalTrue
      ways += subWays
    }

    memo(result + s) = ways
    ways
  }

  def countEval(s: String, result: Boolean): Int = countEval(s, result, HashMap[String, Int]())

  def main(args: Array[String]): Unit = {
    val expression = "0^0|1&1^1|0|1"
    val result = true

    println(countEval(expression, result))
    println(count)
  }
}
