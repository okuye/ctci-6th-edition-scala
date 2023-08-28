package Q10_05_Sparse_Search

object QuestionA {

  def search(strings: Array[String], str: String, first: Int, last: Int): Int = {
    if (first > last) return -1

    var mid = (last + first) / 2

    if (strings(mid).isEmpty) {
      var left = mid - 1
      var right = mid + 1
      while (true) {
        if (left < first && right > last) {
          return -1
        } else if (right <= last && strings(right).nonEmpty) {
          mid = right
          return mid
        } else if (left >= first && strings(left).nonEmpty) {
          mid = left
          return mid
        }
        right += 1
        left -= 1
      }
    }

    if (str == strings(mid)) {
      mid
    } else if (strings(mid).compareTo(str) < 0) {
      search(strings, str, mid + 1, last)
    } else {
      search(strings, str, first, mid - 1)
    }
  }

  def search(strings: Array[String], str: String): Int = {
    if (strings == null || str == null || str.isEmpty) {
      -1
    } else {
      search(strings, str, 0, strings.length - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val stringList = Array("apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower")
    println(search(stringList, "ac"))
    // Uncomment the below lines if you want to test with all strings in the list.
    // stringList.foreach(s => {
    //   println(s"<$s> appears at location ${search(stringList, s)}")
    // })
  }
}
