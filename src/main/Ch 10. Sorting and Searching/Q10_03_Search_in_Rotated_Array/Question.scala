package Q10_03_Search_in_Rotated_Array

object Question {
  def search(a: Array[Int], x: Int): Int = {
    search(a, 0, a.length - 1, x)
  }

  def search(a: Array[Int], left: Int, right: Int, x: Int): Int = {
    val mid = (left + right) / 2
    if (x == a(mid)) {
      return mid
    }
    if (right < left) {
      return -1
    }

    if (a(left) < a(mid)) {
      if (x >= a(left) && x < a(mid)) {
        return search(a, left, mid - 1, x)
      } else {
        return search(a, mid + 1, right, x)
      }
    } else if (a(mid) < a(right)) {
      if (x > a(mid) && x <= a(right)) {
        return search(a, mid + 1, right, x)
      } else {
        return search(a, left, mid - 1, x)
      }
    } else if (a(left) == a(mid)) {
      if (a(mid) != a(right)) {
        return search(a, mid + 1, right, x)
      } else {
        val result = search(a, left, mid - 1, x)
        if (result == -1) {
          return search(a, mid + 1, right, x)
        } else {
          return result
        }
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val a = Array(2, 3, 1, 2, 2, 2, 2, 2, 2, 2)
    println(search(a, 2))
    println(search(a, 3))
    println(search(a, 4))
    println(search(a, 1))
    println(search(a, 8))
  }
}
