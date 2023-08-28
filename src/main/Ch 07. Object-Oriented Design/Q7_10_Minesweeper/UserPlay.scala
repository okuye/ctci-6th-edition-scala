package Q7_10_Minesweeper

class UserPlay private (val row: Int, val column: Int, val isGuess: Boolean) {

  def isMove: Boolean = !isGuess
}

object UserPlay {
  def fromString(input: String): Option[UserPlay] = {
    var isGuess = false
    var processedInput = input

    if (input.nonEmpty && input.charAt(0) == 'B') {
      isGuess = true
      processedInput = input.substring(1)
    }

    val parts = processedInput.split(" ")

    if (parts.length != 2 || !parts(0).forall(_.isDigit) || !parts(1).forall(_.isDigit)) {
      None
    } else {
      val r = parts(0).toInt
      val c = parts(1).toInt
      Some(new UserPlay(r, c, isGuess))
    }
  }
}
