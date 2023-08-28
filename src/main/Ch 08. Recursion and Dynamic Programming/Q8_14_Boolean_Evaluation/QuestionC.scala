package Q8_14_Boolean_Evaluation

object QuestionC {
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

      var subWays = 0
      c match {
        case '^' =>
          if (result) {
            val leftTrue = countEval(left, true)
            val leftFalse = countEval(left, false)
            val rightTrue = countEval(right, true)
            val rightFalse = countEval(right, false)
            subWays = leftTrue * rightFalse + leftFalse * rightTrue
          } else {
            val leftTrue = countEval(left, true)
            val leftFalse = countEval(left, false)
            val rightTrue = countEval(right, true)
            val rightFalse = countEval(right, false)
            subWays = leftTrue * rightTrue + leftFalse * rightFalse
          }
        case '&' =>
          if (result) {
            val leftTrue = countEval(left, true)
            val rightTrue = countEval(right, true)
            subWays = leftTrue * rightTrue
          } else {
            val leftTrue = countEval(left, true)
            val leftFalse = countEval(left, false)
            val rightTrue = countEval(right, true)
            val rightFalse = countEval(right, false)
            subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse
          }
        case '|' =>
          if (result) {
            val leftTrue = countEval(left, true)
            val leftFalse = countEval(left, false)
            val rightTrue = countEval(right, true)
            val rightFalse = countEval(right, false)
            subWays = leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue
          } else {
            val leftFalse = countEval(left, false)
            val rightFalse = countEval(right, false)
            subWays = leftFalse * rightFalse
          }
        case _ =>
      }
      ways += subWays
    }

    ways
  }

  def main(args: Array[String]): Unit = {
    val expression = "0&0&0&1^1|0"
    val result = true

    println(countEval(expression, result))
    println(count)
  }
}
