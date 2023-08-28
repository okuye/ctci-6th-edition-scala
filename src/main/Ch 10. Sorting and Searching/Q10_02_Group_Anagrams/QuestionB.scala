package Q10_02_Group_Anagrams

import CtCILibrary.AssortedMethods

import scala.collection.mutable

object QuestionB {
  def sort(array: Array[String]): Unit = {
    val mapList = new mutable.HashMap[String, mutable.ListBuffer[String]]()

    // Group words by anagram
    for (s <- array) {
      val key = sortChars(s)
      mapList.getOrElseUpdate(key, mutable.ListBuffer[String]()) += s
    }

    // Convert hash table to array
    var index = 0
    for (list <- mapList.values) {
      for (t <- list) {
        array(index) = t
        index += 1
      }
    }
  }

  def sortChars(s: String): String = {
    val content = s.toCharArray
    scala.util.Sorting.quickSort(content)
    new String(content)
  }

  def main(args: Array[String]): Unit = {
    val array = Array("apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee")
    sort(array)
    println(AssortedMethods.stringArrayToString(array))
  }
}
