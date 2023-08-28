package Q8_09_Parens

import scala.collection.mutable

object QuestionA {

  def insertInside(str: String, leftIndex: Int): String = {
    val left = str.substring(0, leftIndex + 1)
    val right = str.substring(leftIndex + 1)
    left + "()" + right
  }

  def generateParens(remaining: Int): Set[String] = {
    val set = mutable.Set[String]()
    if (remaining == 0) {
      set += ""
    } else {
      val prev = generateParens(remaining - 1)
      for (str <- prev) {
        for (i <- str.indices) {
          if (str.charAt(i) == '(') {
            val s = insertInside(str, i)
            set += s
          }
        }
        set += "()" + str
      }
    }
    set.toSet
  }

  def main(args: Array[String]): Unit = {
    val list = generateParens(4)
    list.foreach(println)
    println(list.size)
  }
}
