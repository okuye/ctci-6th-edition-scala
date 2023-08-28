package Q2_01_Remove_Dups

import CtCILibrary.LinkedListNode

object Tester {

  def main(args: Array[String]): Unit = {
    val first = new LinkedListNode(0, null, null)
    var head = first
    var second = first
    var current = first  // Use a separate variable for iteration

    for (i <- 1 until 8) {
      second = new LinkedListNode(i % 2, null, null)
      current.setNext(second)
      second.setPrevious(current)
      current = second
    }

    println(head.printForward())

    val cloneA = head.clone()
    val cloneB = head.clone()
    val cloneC = head.clone()
    QuestionA.deleteDups(cloneA)
    QuestionB.deleteDups(cloneB)  // Assuming you meant QuestionB here
    QuestionC.deleteDups(cloneC)  // Assuming you meant QuestionC here

    println(cloneA.printForward())
    println(cloneB.printForward())
    println(cloneC.printForward())
  }
}
