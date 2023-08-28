package Q2_07_Intersection

import CtCILibrary.AssortedMethods
import CtCILibrary.LinkedListNode

object Question {

  class Result(val tail: LinkedListNode, val size: Int)

  def getTailAndSize(list: LinkedListNode): Result = {
    if (list == null) return null

    var size = 1
    var current = list
    while (current.next != null) {
      size += 1
      current = current.next
    }
    new Result(current, size)
  }

  def getKthNode(head: LinkedListNode, k: Int): LinkedListNode = {
    var current = head
    var count = k
    while (count > 0 && current != null) {
      current = current.next
      count -= 1
    }
    current
  }

  def findIntersection(list1: LinkedListNode, list2: LinkedListNode): LinkedListNode = {
    if (list1 == null || list2 == null) return null

    // Get tail and sizes
    val result1 = getTailAndSize(list1)
    val result2 = getTailAndSize(list2)

    // If different tail nodes, then there's no intersection
    if (result1.tail != result2.tail) {
      return null
    }

    // Set pointers to the start of each linked list
    val shorter = if (result1.size < result2.size) list1 else list2
    val longer = if (result1.size < result2.size) list2 else list1

    // Advance the pointer for the longer linked list by the difference in lengths
    var diff = math.abs(result1.size - result2.size)
    var currentLonger = longer
    while (diff > 0) {
      currentLonger = currentLonger.next
      diff -= 1
    }

    // Move both pointers until you have a collision
    var currentShorter = shorter
    while (currentShorter != currentLonger) {
      currentShorter = currentShorter.next
      currentLonger = currentLonger.next
    }

    // Return either one
    currentLonger
  }

  def main(args: Array[String]): Unit = {
    // Create linked lists
    val vals1 = Array(-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8)
    val list1 = AssortedMethods.createLinkedListFromArray(vals1)

    val vals2 = Array(12, 14, 15)
    val list2 = AssortedMethods.createLinkedListFromArray(vals2)

    list2.next.next = list1.next.next.next.next

    println(list1.printForward())
    println(list2.printForward())

    val intersection = findIntersection(list1, list2)

    println(intersection.printForward())
  }
}
