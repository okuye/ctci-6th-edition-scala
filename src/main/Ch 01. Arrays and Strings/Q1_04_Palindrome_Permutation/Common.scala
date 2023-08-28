package Q1_04_Palindrome_Permutation

object Common {

  def getCharNumber(c: Char): Int = {
    val a = Character.getNumericValue('a')
    val z = Character.getNumericValue('z')

    val value = Character.getNumericValue(c)
    if (a <= value && value <= z) {
      value - a
    } else {
      -1
    }
  }

  def buildCharFrequencyTable(phrase: String): Array[Int] = {
    val table = new Array[Int](Character.getNumericValue('z') - Character.getNumericValue('a') + 1)
    for (c <- phrase.toCharArray) {
      val x = getCharNumber(c)
      if (x != -1) {
        table(x) += 1
      }
    }
    table
  }

}
