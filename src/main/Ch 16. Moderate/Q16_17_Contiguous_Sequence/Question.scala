package Q16_17_Contiguous_Sequence

object Question {

  def getMaxSum(a: Array[Int]): Int = {
    var maxSum = 0
    var runningSum = 0
    for (value <- a) {
      runningSum += value
      if (maxSum < runningSum) {
        maxSum = runningSum
      } else if (runningSum < 0) {
        runningSum = 0
      }
    }
    maxSum
  }

  def main(args: Array[String]): Unit = {
    val a = Array(2, -8, 3, -2, 4, -10)
    println(getMaxSum(a))
  }
}
