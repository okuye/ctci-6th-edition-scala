package Q5_04_Next_Number

object Tester {

  def binPrint(i: Int): Unit = {
    println(s"$i: ${Integer.toBinaryString(i)}")
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 200) {
      val p1 = QuestionA.getPrevSlow(i)
      val p2 = QuestionB.getPrev(i)
      val p3 = QuestionC.getPrevArith(i)

      val n1 = QuestionA.getNextSlow(i)
      val n2 = QuestionB.getNext(i)
      val n3 = QuestionC.getNextArith(i)

      if (p1 != p2 || p2 != p3 || n1 != n2 || n2 != n3) {
        binPrint(i)
        binPrint(p1)
        binPrint(p2)
        binPrint(p3)
        binPrint(n1)
        binPrint(n2)
        binPrint(n3)
        println("")
        return
      }
    }
    println("Done!")
  }
}
