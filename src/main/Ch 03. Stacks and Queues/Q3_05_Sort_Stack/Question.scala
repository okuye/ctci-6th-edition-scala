package Q3_05_Sort_Stack

import scala.collection.mutable.Stack
import CtCILibrary.AssortedMethods

object Question {
  def mergesort(inStack: Stack[Int]): Stack[Int] = {
    if (inStack.size <= 1) {
      return inStack
    }

    val left = Stack[Int]()
    val right = Stack[Int]()
    var count = 0
    while (inStack.nonEmpty) {
      count += 1
      if (count % 2 == 0) {
        left.push(inStack.pop())
      } else {
        right.push(inStack.pop())
      }
    }

    val sortedLeft = mergesort(left)
    val sortedRight = mergesort(right)

    while (sortedLeft.nonEmpty || sortedRight.nonEmpty) {
      if (sortedLeft.isEmpty) {
        inStack.push(sortedRight.pop())
      } else if (sortedRight.isEmpty) {
        inStack.push(sortedLeft.pop())
      } else if (sortedRight.top <= sortedLeft.top) {
        inStack.push(sortedLeft.pop())
      } else {
        inStack.push(sortedRight.pop())
      }
    }

    val reverseStack = Stack[Int]()
    while (inStack.nonEmpty) {
      reverseStack.push(inStack.pop())
    }

    reverseStack
  }

  def sort(s: Stack[Int]): Unit = {
    val r = Stack[Int]()
    while (s.nonEmpty) {
      val tmp = s.pop()
      while (r.nonEmpty && r.top > tmp) {
        s.push(r.pop())
      }
      r.push(tmp)
    }

    while (r.nonEmpty) {
      s.push(r.pop())
    }
  }

  def main(args: Array[String]): Unit = {
    val s = Stack[Int]()
    for (_ <- 0 until 10) {
      val r = AssortedMethods.randomIntInRange(0, 1000)
      s.push(r)
    }

    sort(s)

    while (s.nonEmpty) {
      println(s.pop())
    }
  }
}
