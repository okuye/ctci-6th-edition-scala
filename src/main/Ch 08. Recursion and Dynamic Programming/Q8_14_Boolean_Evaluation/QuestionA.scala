package Q8_14_Boolean_Evaluation

object QuestionA {
  var count = 0

  def stringToBool(c: String): Boolean = c == "1"

  def countEval(s: String, result: Boolean): Int = {
    count += 1
    if (s.isEmpty) return 0
    if (s.length == 1) return if (stringToBool(s) == result) 1 else 0

    var ways = 0

    for (i <- 1 until s.length by 2) {
      val c = s.charAt(i)
      val left = s.substring(0, i)
      val right = s.substring(i + 1)
      val leftTrue = countEval(left, true)
      val leftFalse = countEval(left, false)
      val rightTrue = countEval(right, true)
      val rightFalse = countEval(right, false)
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

    ways
  }

  def main(args: Array[String]): Unit = {
    val expression = "0^0|1&1^1|0|1"
    val result = true

    println(countEval(expression, result))
    println(count)
  }
}
