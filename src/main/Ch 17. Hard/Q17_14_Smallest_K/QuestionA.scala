package Q17_14_Smallest_K

object QuestionA {

  def smallestK(array: Array[Int], k: Int): Array[Int] = {
    if (k <= 0 || k > array.length) throw new IllegalArgumentException()

    array.sorted.take(k)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 5, 2, 9, 1, 11, 6, 13, 15)
    val smallest = smallestK(array, 3)
    println(smallest.mkString(", "))
  }
}
