package Q17_09_Kth_Multiple

import scala.collection.mutable.Queue

object QuestionB {

  def removeMin(q: Queue[Int]): Int = {
    val min = q.min
    while (q.contains(min)) {
      q -= min
    }
    min
  }

  def addProducts(q: Queue[Int], v: Int): Unit = {
    q.enqueue(v * 3)
    q.enqueue(v * 5)
    q.enqueue(v * 7)
  }

  def getKthMagicNumber(k: Int): Int = {
    if (k < 0) {
      return 0
    }
    var val_ = 1
    val q = Queue[Int]()
    addProducts(q, 1)
    for (_ <- 0 until k) {
      val_ = removeMin(q)
      addProducts(q, val_)
    }
    val_
  }

  def main(args: Array[String]): Unit = {
    for (i <- 0 until 14) {
      println(s"$i : ${getKthMagicNumber(i)}")
    }
  }
}
