package Q17_13_ReSpace

class ParseResult(var invalid: Int = Int.MaxValue, var parsed: String = "") {
  override def clone(): ParseResult = new ParseResult(this.invalid, this.parsed)
}

object ParseResult {
  def min(r1: ParseResult, r2: ParseResult): ParseResult = {
    (r1, r2) match {
      case (null, _) => r2
      case (_, null) => r1
      case _ => if (r2.invalid < r1.invalid) r2 else r1
    }
  }
}
