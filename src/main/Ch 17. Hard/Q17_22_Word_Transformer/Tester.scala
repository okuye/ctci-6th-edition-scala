package Q17_22_Word_Transformer

import scala.collection.mutable.{ArrayList, HashSet, LinkedList}
import scala.jdk.CollectionConverters._

object Tester {
  def printList(list: LinkedList[String]): Unit = {
    if (list == null) {
      println("No path.")
    } else {
      println(list.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    val words = Array("maps", "tan", "tree", "apple", "cans", "help", "aped", "pree", "pret", "apes", "flat", "trap", "fret", "trip", "trie", "frat", "fril")
    val listA = QuestionA.transform("tree", "flat", words).asScala
    val listB = QuestionB.transform("tree", "flat", words).asScala
    val listC = QuestionC.transform("tree", "flat", words).asScala
    printList(listA)
    printList(listB)
    printList(listC)
  }
}

