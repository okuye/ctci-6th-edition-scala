package Q16_15_Master_Mind

object Question {
  val MAX_COLORS = 4

  def code(c: Char): Int = c match {
    case 'B' => 0
    case 'G' => 1
    case 'R' => 2
    case 'Y' => 3
    case _ => -1
  }

  def letterFromCode(k: Int): Char = k match {
    case 0 => 'B'
    case 1 => 'G'
    case 2 => 'R'
    case 3 => 'Y'
    case _ => '0'
  }

  case class Result(var hits: Int, var pseudoHits: Int) {
    override def toString: String = s"Hits: $hits, PseudoHits: $pseudoHits"
  }

  def estimate(guess: String, solution: String): Result = {
    if (guess.length != solution.length) return null
    val res = Result(0, 0)
    val frequencies = Array.ofDim[Int](MAX_COLORS)

    // Compute hits and built frequency table
    for (i <- guess.indices) {
      if (guess(i) == solution(i)) {
        res.hits += 1
      } else {
        val codeValue = code(solution(i))
        if (codeValue >= 0) {
          frequencies(codeValue) += 1
        }
      }
    }

    // Compute pseudo-hits
    for (i <- guess.indices) {
      val codeValue = code(guess(i))
      if (codeValue >= 0 && frequencies(codeValue) > 0 && guess(i) != solution(i)) {
        res.pseudoHits += 1
        frequencies(codeValue) -= 1
      }
    }

    res
  }

  def main(args: Array[String]): Unit = {
    val res = estimate("GGRR", "RGBY")
    println(res)
  }
}
