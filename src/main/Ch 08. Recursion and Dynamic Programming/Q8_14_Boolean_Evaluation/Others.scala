package Q8_14_Boolean_Evaluation

import scala.collection.mutable

object Others {

  object Term extends Enumeration {
    type Term = Value
    val True, False, And, Or, Xor, LeftParen, RightParen = Value
  }

  def reduce(expression: String, start: Int, end: Int): String = {
    if (start == end) {
      expression.charAt(start) match {
        case '1' => return "1"
        case '0' => return "0"
        case _   =>
      }
    }

    var count = 0
    var i = start
    val reduced = Array.ofDim[String](3)
    var index = 0
    var left = start
    var right = start
    while (i <= end) {
      if (expression.charAt(i) == '(') {
        if (count == 0) {
          left = i + 1
        }
        count += 1
      } else if (expression.charAt(i) == ')') {
        count -= 1
        if (count == 0) {
          right = i - 1
        }
      }
      if (count == 0) {
        reduced(index) = reduce(expression, left, right)
        if (index == 0) {
          reduced(index + 1) = expression.charAt(i + 1).toString
          i += 1
          left = i + 1
          right = i + 1
        }
        index += 2
      }
      i += 1
    }

    reduced(1) match {
      case "&" =>
        if (reduced(0) == "1" && reduced(2) == "1") {
          "1"
        } else {
          "0"
        }
      case "|" =>
        if (reduced(0) == "1" || reduced(2) == "1") {
          "1"
        } else {
          "0"
        }
      case "^" =>
        if (
          (reduced(0) == "1" && reduced(2) == "0") || (reduced(
            0
          ) == "0" && reduced(2) == "1")
        ) {
          "1"
        } else {
          "0"
        }
      case _ => "0"
    }
  }

  def evaluate(expression: String, start: Int, end: Int): Boolean = {
    reduce(expression, start, end) match {
      case "0" => false
      case _   => true
    }
  }

  def isOperator(c: Char): Boolean = {
    c match {
      case '&' | '|' | '^' => true
      case _               => false
    }
  }

  def insertParensAround(expression: String, ind: Int): String = {
    var left = 0
    var right = 0

    def loopHelper(start: Int, end: Int, step: Int, setLeft: Boolean): Int = {
      var count = 0
      for (i <- start to end by step) {
        expression.charAt(i) match {
          case ')' => count += 1
          case '(' => count -= 1
          case _   =>
        }
        if (count == 0) {
          if (setLeft) left = i else right = i
          return i
        }
      }
      end
    }

    var index = 0
    var count = 0
    for (i <- 0 until expression.length if isOperator(expression.charAt(i))) {
      if (count == ind) {
        index = i
      }
      count += 1
    }

    loopHelper(index - 1, 0, -1, true)
    loopHelper(index + 1, expression.length, 1, false)

    if (left == 0 && right == expression.length - 1) {
      expression
    } else {
      expression.substring(0, left) + "(" + expression.substring(
        left,
        right + 1
      ) + ")" + expression.substring(right + 1)
    }
  }

  def bruteForce(
      expression: String,
      completed: mutable.HashMap[String, Boolean],
      result: Boolean,
      flags: Array[Boolean]
  ): Int = {
    var count = 0
    var isDone = true
    if (completed.contains(expression)) {
      return 0
    }

    for (i <- flags.indices if !flags(i)) {
      flags(i) = true
      val newExpression = insertParensAround(expression, i)
      isDone = false
      count += bruteForce(newExpression, completed, result, flags)
      flags(i) = false
    }

    if (isDone) {
      if (evaluate(expression, 0, expression.length - 1) == result) {
        1
      } else {
        0
      }
    } else {
      completed(expression) = true
      count
    }
  }

  def countR(exp: String, result: Boolean, start: Int, end: Int): Int = {
    if (start == end) {
      exp.charAt(start) match {
        case '1' if result  => return 1
        case '0' if !result => return 1
        case _              => return 0
      }
    }

    var c = 0
    if (result) {
      for (i <- start + 1 to end by 2) {
        exp.charAt(i) match {
          case '&' =>
            c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
          case '|' =>
            c += countR(exp, true, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              true,
              i + 1,
              end
            )
            c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
          case '^' =>
            c += countR(exp, true, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              true,
              i + 1,
              end
            )
          case _ =>
        }
      }
    } else {
      for (i <- start + 1 to end by 2) {
        exp.charAt(i) match {
          case '&' =>
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              true,
              i + 1,
              end
            )
            c += countR(exp, true, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
          case '|' =>
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
          case '^' =>
            c += countR(exp, true, start, i - 1) * countR(exp, true, i + 1, end)
            c += countR(exp, false, start, i - 1) * countR(
              exp,
              false,
              i + 1,
              end
            )
          case _ =>
        }
      }
    }
    c
  }

  def countDP(
      exp: String,
      result: Boolean,
      start: Int,
      end: Int,
      cache: mutable.HashMap[String, Int]
  ): Int = {
    val key = s"$result$start$end"
    if (cache.contains(key)) {
      return cache(key)
    }

    if (start == end) {
      exp.charAt(start) match {
        case '1' if result  => return 1
        case '0' if !result => return 1
        case _              => return 0
      }
    }

    var count = 0
    if (result) {
      for (i <- start + 1 to end by 2) {
        exp.charAt(i) match {
          case '&' =>
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
          case '|' =>
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
          case '^' =>
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
          case _ =>
        }
      }
    } else {
      for (i <- start + 1 to end by 2) {
        exp.charAt(i) match {
          case '&' =>
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
          case '|' =>
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
          case '^' =>
            count += countDP(exp, true, start, i - 1, cache) * countDP(
              exp,
              true,
              i + 1,
              end,
              cache
            )
            count += countDP(exp, false, start, i - 1, cache) * countDP(
              exp,
              false,
              i + 1,
              end,
              cache
            )
          case _ =>
        }
      }
    }

    cache(key) = count
    count
  }

  def total(n: Int): Int = {
    var num = 1L
    var rem = 1L
    for (i <- 2 to n) {
      num *= (n + i)
      rem *= i
      if (num % rem == 0) {
        num /= rem
        rem = 1
      }
    }
    num.toInt
  }

  def countDPEff(
      exp: String,
      result: Boolean,
      start: Int,
      end: Int,
      cache: mutable.HashMap[String, Int]
  ): Int = {
    val key = s"$start$end"
    var count = 0
    if (!cache.contains(key)) {
      if (start == end) {
        exp.charAt(start) match {
          case '1' => count = 1
          case _   => count = 0
        }
      }

      for (i <- start + 1 to end by 2) {
        exp.charAt(i) match {
          case '&' =>
            count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(
              exp,
              true,
              i + 1,
              end,
              cache
            )
          case '|' =>
            val left_ops = (i - 1 - start) / 2
            val right_ops = (end - i - 1) / 2
            val total_ways = total(left_ops) * total(right_ops)
            val total_false = countDPEff(
              exp,
              false,
              start,
              i - 1,
              cache
            ) * countDPEff(exp, false, i + 1, end, cache)
            count += total_ways - total_false
          case '^' =>
            count += countDPEff(exp, true, start, i - 1, cache) * countDPEff(
              exp,
              false,
              i + 1,
              end,
              cache
            )
            count += countDPEff(exp, false, start, i - 1, cache) * countDPEff(
              exp,
              true,
              i + 1,
              end,
              cache
            )
          case _ =>
        }
      }
      cache(key) = count
    } else {
      count = cache(key)
    }

    if (result) {
      count
    } else {
      val num_ops = (end - start) / 2
      total(num_ops) - count
    }
  }

  def main(args: Array[String]): Unit = {
    val terms = "0^0|1&1^1|0|1"
    val result = true

    bruteForce(
      terms,
      mutable.HashMap[String, Boolean](),
      result,
      Array.ofDim[Boolean]((terms.length - 1) / 2)
    )
    println(countR(terms, result, 0, terms.length - 1))
    println(
      countDP(
        terms,
        result,
        0,
        terms.length - 1,
        mutable.HashMap[String, Int]()
      )
    )
    println(
      countDPEff(
        terms,
        result,
        0,
        terms.length - 1,
        mutable.HashMap[String, Int]()
      )
    )
  }
}
