package Q16_26_Calculator

import scala.collection.mutable.Stack
import scala.jdk.CollectionConverters._


object QuestionB {
  def parseNextOperator(sequence: String, offset: Int): Operator.Value = {
    if (offset < sequence.length()) {
      val op = sequence.charAt(offset)
      op match {
        case '+' => Operator.ADD
        case '-' => Operator.SUBTRACT
        case '*' => Operator.MULTIPLY
        case '/' => Operator.DIVIDE
        case _ => Operator.BLANK
      }
    } else {
      Operator.BLANK
    }
  }

  def parseNextNumber(seq: String, offset: Int): Int = {
    val sb = new StringBuilder()
    var i = offset
    while (i < seq.length() && seq.charAt(i).isDigit) {
      sb.append(seq.charAt(i))
      i += 1
    }
    sb.toString().toInt
  }

  def applyOp(left: Double, op: Operator.Value, right: Double): Double = {
    op match {
      case Operator.ADD => left + right
      case Operator.SUBTRACT => left - right
      case Operator.MULTIPLY => left * right
      case Operator.DIVIDE => left / right
      case Operator.BLANK => right
    }
  }

  def priorityOfOperator(op: Operator.Value): Int = {
    op match {
      case Operator.ADD => 1
      case Operator.SUBTRACT => 1
      case Operator.MULTIPLY => 2
      case Operator.DIVIDE => 2
      case Operator.BLANK => 0
    }
  }

  def collapseTop(futureTop: Operator.Value, numberStack: Stack[Double], operatorStack: Stack[Operator.Value]): Unit = {
    while (operatorStack.size >= 1 && numberStack.size >= 2) {
      if (priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.top)) {
        val second = numberStack.pop()
        val first = numberStack.pop()
        val op = operatorStack.pop()
        val collapsed = applyOp(first, op, second)
        numberStack.push(collapsed)
      } else {
        return
      }
    }
  }

  def compute(sequence: String): Double = {
    val numberStack = new Stack[Double]()
    val operatorStack = new Stack[Operator.Value]()

    var i = 0
    while (i < sequence.length()) {
      try {
        val value = parseNextNumber(sequence, i)
        numberStack.push(value.toDouble)

        i += value.toString.length
        if (i >= sequence.length()) {
          return Double.MinValue
        }

        val op = parseNextOperator(sequence, i)
        collapseTop(op, numberStack, operatorStack)
        operatorStack.push(op)

      } catch {
        case _: NumberFormatException => return Double.MinValue
      }
    }

    collapseTop(Operator.BLANK, numberStack, operatorStack)
    if (numberStack.size == 1 && operatorStack.isEmpty) {
      numberStack.pop()
    } else {
      0
    }
  }

  def main(args: Array[String]): Unit = {
    val expression = "6/5*3+4*5/2-12/6*3/3+3+3"
    val result = compute(expression)
    println(result)
  }
}