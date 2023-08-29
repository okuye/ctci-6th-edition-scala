package Q17_05_Letters_and_Numbers

object Tester {

  def main(args: Array[String]): Unit = {
    val b = 'b'
    val a = '1'
    val array = Array(a, b, a, b, a, b, b, b, b, b, a, a, a, a, a, b, a, b, a, b, b, a, a, a, a, a, a, a)
    array.foreach(ch => print(s"$ch "))
    println("\n")

    val maxA = QuestionA.findLongestSubarray(array)
    val maxB = QuestionB.findLongestSubarray(array)

    if (maxA.isEmpty) {
      println("A is null.")
    } else {
      println(s"A: ${maxA.length}")
      maxA.foreach(ch => print(s"$ch "))
      println(s"\nIs Valid? ${QuestionA.hasEqualLettersNumbers(maxA, 0, maxA.length - 1)}\n")
    }

    if (maxB.isEmpty) {
      println("B is null.")
    } else {
      println(s"B: ${maxB.length}")
      maxB.foreach(ch => print(s"$ch "))
      println(s"\nIs Valid? ${QuestionA.hasEqualLettersNumbers(maxB, 0, maxB.length - 1)}")
    }
  }
}
