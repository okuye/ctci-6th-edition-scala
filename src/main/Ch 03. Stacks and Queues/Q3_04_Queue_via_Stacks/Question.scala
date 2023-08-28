package Q3_04_Queue_via_Stacks

import CtCILibrary.AssortedMethods
import scala.collection.mutable.Queue

object Question {
  def main(args: Array[String]): Unit = {
    val myQueue = new MyQueue[Int]

    // Let's test our code against a "real" queue
    val testQueue = Queue[Int]()

    for (_ <- 0 until 100) {
      val choice = AssortedMethods.randomIntInRange(0, 10)
      if (choice <= 5) { // enqueue
        val element = AssortedMethods.randomIntInRange(1, 10)
        testQueue.enqueue(element)
        myQueue.add(element)
        println(s"Enqueued $element")
      } else if (testQueue.nonEmpty) {
        val top1 = testQueue.dequeue()
        val top2 = myQueue.remove()
        if (top1 != top2) { // Check for error
          println(s"******* FAILURE - DIFFERENT TOPS: $top1, $top2")
        }
        println(s"Dequeued $top1")
      }

      if (testQueue.size == myQueue.size()) {
        if (testQueue.nonEmpty && testQueue.head != myQueue.peek()) {
          println(s"******* FAILURE - DIFFERENT TOPS: ${testQueue.head}, ${myQueue.peek()} ******")
        }
      } else {
        println("******* FAILURE - DIFFERENT SIZES ******")
      }
    }
  }
}
