package Q2_04_Partition

import CtCILibrary.LinkedListNode

object Tester {

  def createLinkedList(): LinkedListNode = {
    val vals = Array(3, 5, 8, 5, 10, 2, 1)
    val head = new LinkedListNode(vals(0), null, null)
    var current = head
    for (i <- 1 until vals.length) {
      current = new LinkedListNode(vals(i), null, current)
    }
    head
  }

  def main(args: Array[String]): Unit = {
    println(createLinkedList().printForward())

    // Partition
    val hA = Question.partition(createLinkedList(), 5)
    val hB = QuestionB.partition(createLinkedList(), 5)
    val hC = QuestionC.partition(createLinkedList(), 5)

    // Print Result
    println(hA.printForward())
    println(hB.printForward())
    println(hC.printForward())
  }
}
