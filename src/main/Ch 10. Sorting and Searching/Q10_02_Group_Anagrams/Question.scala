package Q10_02_Group_Anagrams

import CtCILibrary.AssortedMethods

object Question {
  def main(args: Array[String]): Unit = {
    val array = Array("apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee")
    println(AssortedMethods.stringArrayToString(array))
    scala.util.Sorting.quickSort(array)(AnagramComparator)
    println(AssortedMethods.stringArrayToString(array))
  }
}
