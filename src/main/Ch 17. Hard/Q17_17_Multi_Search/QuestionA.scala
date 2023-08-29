package Q17_17_Multi_Search

import scala.collection.mutable

object QuestionA {

  def isSubstringAtLocation(big: String, small: String, offset: Int): Boolean = {
    for (i <- 0 until small.length) {
      if (big.charAt(offset + i) != small.charAt(i)) {
        return false
      }
    }
    true
  }

  def search(big: String, small: String): mutable.Buffer[Int] = {
    val locations = mutable.Buffer[Int]()
    for (i <- 0 until big.length - small.length + 1) {
      if (isSubstringAtLocation(big, small, i)) {
        locations += i
      }
    }
    locations
  }

  def searchAll(big: String, smalls: Array[String]): mutable.Map[String, mutable.Buffer[Int]] = {
    val lookup = mutable.Map[String, mutable.Buffer[Int]]()
    for (small <- smalls) {
      lookup.put(small, search(big, small))
    }
    lookup
  }

  def main(args: Array[String]): Unit = {
    val big = "mississippi"
    val smalls = Array("is", "ppi", "hi", "sis", "i", "mississippi")
    val locations = searchAll(big, smalls)
    println(locations)
  }
}
