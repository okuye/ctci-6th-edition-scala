package Q16_16_Sub_Sort

object Question {

  def findEndOfLeftSubsequence(array: Array[Int]): Int = {
    for (i <- 1 until array.length) {
      if (array(i) < array(i - 1)) {
        return i - 1
      }
    }
    array.length - 1
  }

  def findStartOfRightSubsequence(array: Array[Int]): Int = {
    for (i <- array.length - 2 to 0 by -1) {
      if (array(i) > array(i + 1)) {
        return i + 1
      }
    }
    0
  }

  def shrinkLeft(array: Array[Int], min_index: Int, start: Int): Int = {
    val comp = array(min_index)
    for (i <- start - 1 to 0 by -1) {
      if (array(i) <= comp) {
        return i + 1
      }
    }
    0
  }

  def shrinkRight(array: Array[Int], max_index: Int, start: Int): Int = {
    val comp = array(max_index)
    for (i <- start until array.length) {
      if (array(i) >= comp) {
        return i - 1
      }
    }
    array.length - 1
  }

  def findUnsortedSequence(array: Array[Int]): Range = {
    val end_left = findEndOfLeftSubsequence(array)

    if (end_left >= array.length - 1) {
      return Range(0, 0)
    }

    val start_right = findStartOfRightSubsequence(array)
    var max_index = end_left
    var min_index = start_right

    for (i <- end_left + 1 until start_right) {
      if (array(i) < array(min_index)) {
        min_index = i
      }
      if (array(i) > array(max_index)) {
        max_index = i
      }
    }
    val left_index = shrinkLeft(array, min_index, end_left)
    val right_index = shrinkRight(array, max_index, start_right)

    Range(left_index, right_index)
  }

  def validate(array: Array[Int], left_index: Int, right_index: Int): Boolean = {
    val middle = Array.ofDim[Int](right_index - left_index + 1)
    for (i <- left_index to right_index) {
      middle(i - left_index) = array(i)
    }
    scala.util.Sorting.quickSort(middle)
    for (i <- left_index to right_index) {
      array(i) = middle(i - left_index)
    }
    for (i <- 1 until array.length) {
      if (array(i - 1) > array(i)) {
        return false
      }
    }
    true
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19)
    val r = findUnsortedSequence(array)
    println(r.toString)
    println(s"${array(r.start)}, ${array(r.end)}")
  }
}
