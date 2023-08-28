package Q8_04_Power_Set

object QuestionB {

  def convertIntToSet(x: Int, set: List[Int]): List[Int] = {
    var subset = List[Int]()
    var index = 0
    var k = x
    while (k > 0) {
      if ((k & 1) == 1) {
        subset = subset :+ set(index)
      }
      index += 1
      k >>= 1
    }
    subset
  }

  def getSubsets(set: List[Int]): List[List[Int]] = {
    val max = 1 << set.size  // Compute 2^n
    (for (k <- 0 until max) yield convertIntToSet(k, set)).toList
  }

  def main(args: Array[String]): Unit = {
    val list = List(0, 1, 2)
    val subsets2 = getSubsets(list)
    println(subsets2.mkString(", "))
  }
}
