package Q16_26_Calculator

import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

class Term(private var value: Double, private var operator: Operator.Value) {
  def getNumber(): Double = value

  def getOperator(): Operator.Value = operator

  def setNumber(v: Double): Unit = value = v
}

object Term {
  def parseTermSequence(sequence: String): List[Term] = {
    val terms = ListBuffer[Term]()
    var offset = 0
    while (offset < sequence.length) {
      var op = Operator.BLANK
      if (offset > 0) {
        op = parseOperator(sequence.charAt(offset))
        if (op == Operator.BLANK) {
          return null
        }
        offset += 1
      }
      try {
        val value = parseNextNumber(sequence, offset)
        offset += value.toString.length
        val term = new Term(value, op)
        terms += term
      } catch {
        case _: NumberFormatException => return null
      }
    }
    terms.toList
  }

  def parseOperator(op: Char): Operator.Value = {
    op match {
      case '+' => Operator.ADD
      case '-' => Operator.SUBTRACT
      case '*' => Operator.MULTIPLY
      case '/' => Operator.DIVIDE
      case _ => Operator.BLANK
    }
  }

  def parseNextNumber(sequence: String, offset: Int): Int = {
    val sb = new StringBuilder()
    var i = offset
    while (i < sequence.length && sequence.charAt(i).isDigit) {
      sb.append(sequence.charAt(i))
      i += 1
    }
    sb.toString().toInt
  }
}

object QuestionB {
  def compute(sequence: String): Double = {
    // Implementation of compute method
    0.0 // Placeholder return value
  }

  def main(args: Array[String]): Unit = {
    val expression = "6/5*3+4*5/2-12/6*3/3+3+3"
    val result = compute(expression)
    println(result)
  }
}