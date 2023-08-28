package Q5_04_Next_Number

object QuestionC {

  def getNextArith(n: Int): Int = {
    var c = n
    var c0 = 0
    var c1 = 0
    while (((c & 1) == 0) && (c != 0)) {
      c0 += 1
      c >>= 1
    }

    while ((c & 1) == 1) {
      c1 += 1
      c >>= 1
    }

    if (c0 + c1 == 31 || c0 + c1 == 0) {
      return -1
    }

    n + (1 << c0) + (1 << (c1 - 1)) - 1
  }

  def getPrevArith(n: Int): Int = {
    var temp = n
    var c0 = 0
    var c1 = 0
    while (((temp & 1) == 1) && (temp != 0)) {
      c1 += 1
      temp >>= 1
    }

    if (temp == 0) {
      return -1
    }

    while ((temp & 1) == 0 && (temp != 0)) {
      c0 += 1
      temp >>= 1
    }

    n - (1 << c1) - (1 << (c0 - 1)) + 1
  }

  def binPrint(i: Int): Unit = {
    println(s"$i: ${Integer.toBinaryString(i)}")
  }

  def main(args: Array[String]): Unit = {
    val i = 13948
    val p1 = getPrevArith(i)
    val n1 = getNextArith(i)
    Tester.binPrint(p1)
    Tester.binPrint(n1)
  }
}
