package Introduction

object Quicksort {

  def swap(array: Array[Int], i: Int, j: Int): Unit = {
    val tmp = array(i)
    array(i) = array(j)
    array(j) = tmp
  }

  def partition(arr: Array[Int], left: Int, right: Int): Int = {
    val pivot = arr(left + (right - left) / 2)

    var l = left
    var r = right

    while (l <= r) {
      while (arr(l) < pivot) {
        l += 1
      }

      while (arr(r) > pivot) {
        r -= 1
      }

      if (l <= r) {
        swap(arr, l, r)
        l += 1
        r -= 1
      }
    }
    l
  }

  def quickSort(arr: Array[Int], left: Int, right: Int): Unit = {
    val index = partition(arr, left, right)
    if (left < index - 1) {
      quickSort(arr, left, index - 1)
    }
    if (index < right) {
      quickSort(arr, index, right)
    }
  }

  def main(args: Array[String]): Unit = {
    val arr = AssortedMethods.randomArray(20, 0, 6)
    AssortedMethods.printIntArray(arr)
    quickSort(arr, 0, arr.length - 1)
    AssortedMethods.printIntArray(arr)
  }
}
