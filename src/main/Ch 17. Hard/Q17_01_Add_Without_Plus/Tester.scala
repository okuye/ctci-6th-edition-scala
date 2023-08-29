package Q17_01_Add_Without_Plus
import scala.util.Random
object Tester {
  def randomInt(n: Int): Int = {
    Random.nextInt(n)
  }

  def main(args: Array[String]): Unit = {
    for (a <- 0 until 1000) {
      for (b <- 0 until 1000) {
        val sumA = QuestionA.add(a, b)
        val sumB = QuestionB.add(a, b)
        val sum = a + b
        if (sumA != sum || sumB != sum) {
          println(s"ERROR: $a + $b = $sum vs: $sumA, $sumB")
        } else {
          println(s"SUCCESS: $a + $b = $sum")
        }
      }
    }
  }
}