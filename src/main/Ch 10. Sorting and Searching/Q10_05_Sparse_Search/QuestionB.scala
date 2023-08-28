package Q10_05_Sparse_Search

object QuestionB {

  def searchI(strings: Array[String], str: String, first: Int, last: Int): Int = {
    var left = first
    var right = last
    while (left <= right) {
      var mid = (left + right) / 2

      if (strings(mid).isEmpty) {
        var leftMid = mid - 1
        var rightMid = mid + 1
        while (true) {
          if (leftMid < left && rightMid > right) {
            return -1
          } else if (rightMid <= right && strings(rightMid).nonEmpty) {
            mid = rightMid
            return mid
          } else if (leftMid >= left && strings(leftMid).nonEmpty) {
            mid = leftMid
            return mid
          }
          rightMid += 1
          leftMid -= 1
        }
      }

      val res = strings(mid).compareTo(str)
      if (res == 0) {
        return mid
      } else if (res < 0) {
        left = mid + 1
      } else {
        right = mid - 1
      }
    }
    -1
  }

  def searchR(strings: Array[String], str: String, first: Int, last: Int): Int = {
    if (first > last) return -1

    var mid = (last + first) / 2

    if (strings(mid).isEmpty) {
      var leftMid = mid - 1
      var rightMid = mid + 1
      while (true) {
        if (leftMid < first && rightMid > last) {
          return -1
        } else if (rightMid <= last && strings(rightMid).nonEmpty) {
          mid = rightMid
          return mid
        } else if (leftMid >= first && strings(leftMid).nonEmpty) {
          mid = leftMid
          return mid
        }
        rightMid += 1
        leftMid -= 1
      }
    }

    if (str == strings(mid)) {
      mid
    } else if (strings(mid).compareTo(str) < 0) {
      searchR(strings, str, mid + 1, last)
    } else {
      searchR(strings, str, first, mid - 1)
    }
  }

  def search(strings: Array[String], str: String): Int = {
    if (strings == null || str == null || str.isEmpty) {
      -1
    } else {
      searchR(strings, str, 0, strings.length - 1)
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
