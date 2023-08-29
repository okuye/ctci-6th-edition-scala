package Q16_26_Calculator

object QuestionA {
  def collapseTerm(primary: Term, secondary: Term): Term = {
    if (primary == null) secondary
    else if (secondary == null) primary
    else {
      val value = applyOp(primary.getNumber(), secondary.getOperator(), secondary.getNumber())
      primary.setNumber(value)
      primary
    }
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

  def compute(sequence: String): Double = {
    val terms = Term.parseTermSequence(sequence)
    if (terms == null) return Double.MinValue

    var result = 0.0
    var processing: Term = null
    for (i <- 0 until terms.length) {
      val current = terms(i)
      val next = if (i + 1 < terms.length) terms(i + 1) else null

      processing = collapseTerm(processing, current)

      if (next == null || next.getOperator() == Operator.ADD || next.getOperator() == Operator.SUBTRACT) {
        result = applyOp(result, processing.getOperator(), processing.getNumber())
        processing = null
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val expression = "6/5*3+4*5/2-12/6*3/3+3+3"
    val result = compute(expression)
    println(result)
  }
}