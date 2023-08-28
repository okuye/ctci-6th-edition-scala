package Introduction

import CtCILibrary.AssortedMethods

import scala.collection.mutable
import scala.util.control.NonFatal

object QueueTester {

  def main(args: Array[String]): Unit = {
    val array = AssortedMethods.randomArray(100, -100, 100)
    val queue1 = new MyQueue[Int]
    val queue2 = new mutable.Queue[Int]

    for (a <- array) {
      if (a < 0) {
        val top1 = try {
          queue1.remove()
        } catch {
          case NonFatal(_) => Int.MinValue
        }
        val top2 = try {
          queue2.dequeue()
        } catch {
          case NonFatal(_) => Int.MinValue
        }
        if (top1 != top2) {
          println(s"ERROR: mismatching tails")
        } else {
          println(s"SUCCESS: matching tails: $top1")
        }
      } else {
        queue1.add(a)
        queue2.enqueue(a)
      }
    }

    while (!queue1.isEmpty || queue2.nonEmpty) {
      val top1 = try {
        queue1.remove()
      } catch {
        case NonFatal(_) => Int.MinValue
      }
      val top2 = try {
        queue2.dequeue()
      } catch {
        case NonFatal(_) => Int.MinValue
      }
      if (top1 != top2) {
        println(s"ERROR: mismatching tails")
      } else {
        println(s"SUCCESS: matching tails: $top1")
      }
    }
  }
}
