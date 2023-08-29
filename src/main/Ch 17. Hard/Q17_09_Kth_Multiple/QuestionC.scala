package Q17_09_Kth_Multiple

import scala.collection.mutable.Queue

object QuestionC {

  def printQueue(q: Queue[Int], x: Int): Unit = {
    print(s"$x: ")
    q.foreach(a => print(s"${a / x}, "))
    println()
  }

  def getKthMagicNumber(k: Int): Int = {
    if (k < 0) {
      return 0
    }
    var value = 0
    val queue3 = Queue[Int](1)
    val queue5 = Queue[Int]()
    val queue7 = Queue[Int]()
    for (_ <- 0 to k) {
      val v3 = if (queue3.nonEmpty) queue3.head else Int.MaxValue
      val v5 = if (queue5.nonEmpty) queue5.head else Int.MaxValue
      val v7 = if (queue7.nonEmpty) queue7.head else Int.MaxValue
      value = math.min(v3, math.min(v5, v7))
      if (value == v3) {
        queue3.dequeue()
        queue3.enqueue(3 * value)
        queue5.enqueue(5 * value)
      } else if (value == v5) {
        queue5.dequeue()
        queue5.enqueue(5 * value)
      } else if (value == v7) {
        queue7.dequeue()
      }
      queue7.enqueue(7 * value)
    }
    value
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 14) {
      println(s"$i : ${getKthMagicNumber(i)}")
    }
  }
}
