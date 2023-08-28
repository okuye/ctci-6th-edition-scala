package Q10_04_Sorted_Search_No_Size.Arrayish

object Question {

  def binarySearch(list: Listy, value: Int, low: Int, high: Int): Int = {
    var l = low
    var h = high
    var mid = 0

    while (l <= h) {
      mid = (l + h) / 2
      val middle = list.elementAt(mid)
      if (middle > value || middle == -1) {
        h = mid - 1
      } else if (middle < value) {
        l = mid + 1
      } else {
        return mid
      }
    }
    -1
  }

  def search(list: Listy, value: Int): Int = {
    var index = 1
    while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
      index *= 2
    }
    binarySearch(list, value, index / 2, index)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18)
    val list = new Listy(array)
    array.foreach(a => println(search(list, a)))
    println(search(list, 15))
  }
}
