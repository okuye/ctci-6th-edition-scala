package Q2_08_Loop_Detection

import CtCILibrary.LinkedListNode

import scala.util.control.Breaks.break

object Question {

  def findBeginning(head: LinkedListNode): LinkedListNode = {
    var slow = head
    var fast = head

    // Find meeting point
    while (fast != null && fast.next != null) {
      slow = slow.next
      fast = fast.next.next
      if (slow == fast) {
        break
      }
    }

    // Error check - there is no meeting point, and therefore no loop
    if (fast == null || fast.next == null) {
      return null
    }

    /* Move slow to Head. Keep fast at Meeting Point. Each are k steps
     * from the Loop Start. If they move at the same pace, they must
     * meet at Loop Start. */
    slow = head
    while (slow != fast) {
      slow = slow.next
      fast = fast.next
    }

    // Both now point to the start of the loop.
    fast
  }

  def main(args: Array[String]): Unit = {
    val list_length = 100
    val k = 10

    // Create linked list
    val nodes = new Array[LinkedListNode](list_length)
    for (i <- 0 until list_length) {
      nodes(i) = new LinkedListNode(i, null, if (i > 0) nodes(i - 1) else null)
    }

    // Create loop;
    nodes(list_length - 1).next = nodes(list_length - k)

    val loop = findBeginning(nodes(0))
    if (loop == null) {
      println("No Cycle.")
    } else {
      println(loop.data)
    }
  }
}
