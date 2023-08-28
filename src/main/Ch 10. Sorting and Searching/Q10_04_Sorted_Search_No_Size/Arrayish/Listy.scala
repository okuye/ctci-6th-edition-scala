package Q10_04_Sorted_Search_No_Size.Arrayish

class Listy(arr: Array[Int]) {
  private val array: Array[Int] = arr.clone()

  def elementAt(index: Int): Int = {
    if (index >= array.length) {
      return -1
    }
    array(index)
  }
}
