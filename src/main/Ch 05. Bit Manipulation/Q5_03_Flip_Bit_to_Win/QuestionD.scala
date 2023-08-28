package Q5_03_Flip_Bit_to_Win

object QuestionD {

  def flipBit(a: Int): Int = {
    if (~a == 0) return Integer.BYTES * 8

    var currentLength = 0
    var previousLength = 0
    var maxLength = 1
    var mutableA = a

    while (mutableA != 0) {
      if ((mutableA & 1) == 1) {
        currentLength += 1
      } else if ((mutableA & 1) == 0) {
        previousLength = if ((mutableA & 2) == 0) 0 else currentLength
        currentLength = 0
      }
      maxLength = Math.max(previousLength + currentLength + 1, maxLength)
      mutableA >>>= 1
    }
    maxLength
  }

  def main(args: Array[String]): Unit = {
    val cases = Array(
      Array(-1, 32),
      Array(Int.MaxValue, 32),
      Array(-10, 31),
      Array(0, 1),
      Array(1, 2),
      Array(15, 5),
      Array(1775, 8)
    )

    for (c <- cases) {
      val x = flipBit(c(0))
      val r = c(1) == x
      println(s"${c(0)}: $x, ${c(1)} $r")
    }
  }
}
