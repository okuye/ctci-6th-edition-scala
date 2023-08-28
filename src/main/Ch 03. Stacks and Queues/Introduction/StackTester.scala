package Introduction

import CtCILibrary.AssortedMethods

import scala.collection.mutable
import scala.util.control.NonFatal

object StackTester {

  def main(args: Array[String]): Unit = {
    val array = AssortedMethods.randomArray(100, -100, 100)
    val stack1 = new MyStack[Int]
    val stack2 = new mutable.Stack[Int]

    for (a <- array) {
      if (a < 0) {
        val top1 = try {
          stack1.pop()
        } catch {
          case NonFatal(_) => Int.MinValue
        }
        val top2 = try {
          stack2.pop()
        } catch {
          case NonFatal(_) => Int.MinValue
        }
        if (top1 != top2) {
          println(s"ERROR: mismatching tops")
        } else {
          println(s"SUCCESS: matching tops: $top1")
        }
      } else {
        stack1.push(a)
        stack2.push(a)
      }
    }

    while (!stack1.isEmpty || !stack2.isEmpty) {
      val top1 = try {
        stack1.pop()
      } catch {
        case NonFatal(_) => Int.MinValue
      }
      val top2 = try {
        stack2.pop()
      } catch {
        case NonFatal(_) => Int.MinValue
      }
      if (top1 != top2) {
        println(s"ERROR: mismatching tops")
      } else {
        println(s"SUCCESS: matching tops: $top1")
      }
    }
  }
}
