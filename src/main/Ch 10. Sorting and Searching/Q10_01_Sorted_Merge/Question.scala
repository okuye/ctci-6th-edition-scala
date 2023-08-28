package Q10_01_Sorted_Merge

object Question {

  /** Merges array
   * @param a first array
   * @param b second array
   * @param countA number of "real" elements in a
   * @param countB number of "real" elements in b
   */
  def merge(a: Array[Int], b: Array[Int], countA: Int, countB: Int): Unit = {
    var indexMerged = countB + countA - 1
    var indexA = countA - 1
    var indexB = countB - 1

    while (indexB >= 0) {
      if (indexA >= 0 && a(indexA) > b(indexB)) {
        a(indexMerged) = a(indexA)
        indexA -= 1
      } else {
        a(indexMerged) = b(indexB)
        indexB -= 1
      }
      indexMerged -= 1
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0)
    val b = Array(1, 4, 7, 6, 7, 7)
    merge(a, b, 8, 6)
    println(a.mkString(", "))
  }
}
