package Q5_04_Next_Number

object QuestionA {

  def countOnes(i: Int): Int = {
    var count = 0
    var temp = i
    while (temp > 0) {
      if ((temp & 1) == 1) {
        count += 1
      }
      temp >>= 1
    }
    count
  }

  def countZeros(i: Int): Int = 32 - countOnes(i)

  def hasValidNext(i: Int): Boolean = {
    if (i == 0) return false
    var count = 0
    var temp = i
    while ((temp & 1) == 0) {
      temp >>= 1
      count += 1
    }
    while ((temp & 1) == 1) {
      temp >>= 1
      count += 1
    }
    count != 31
  }

  def hasValidPrev(i: Int): Boolean = {
    var temp = i
    while ((temp & 1) == 1) {
      temp >>= 1
    }
    temp != 0
  }

  def getNextSlow(i: Int): Int = {
    if (!hasValidNext(i)) return -1
    var num_ones = countOnes(i)
    var temp = i + 1
    while (countOnes(temp) != num_ones) {
      temp += 1
    }
    temp
  }

  def getPrevSlow(i: Int): Int = {
    if (!hasValidPrev(i)) return -1
    var num_ones = countOnes(i)
    var temp = i - 1
    while (countOnes(temp) != num_ones) {
      temp -= 1
    }
    temp
  }

  def main(args: Array[String]): Unit = {
    val i = 13948
    val p1 = getPrevSlow(i)
    val n1 = getNextSlow(i)
    Tester.binPrint(p1)
    Tester.binPrint(n1)
  }
}
