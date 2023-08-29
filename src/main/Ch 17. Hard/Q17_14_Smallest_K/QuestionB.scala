package Q17_14_Smallest_K

import scala.collection.mutable.PriorityQueue

object QuestionB {

  object MaxHeapOrdering extends Ordering[Int] {
    def compare(x: Int, y: Int): Int = y - x
  }

  def smallestK(array: Array[Int], k: Int): Array[Int] = {
    if (k <= 0 || k > array.length) throw new IllegalArgumentException()

    val heap = getKMaxHeap(array, k)
    heapToArray(heap)
  }

  def heapToArray(heap: PriorityQueue[Int]): Array[Int] = {
    val array = new Array[Int](heap.size)
    var idx = array.length - 1
    while (heap.nonEmpty) {
      array(idx) = heap.dequeue()
      idx -= 1
    }
    array
  }

  def getKMaxHeap(array: Array[Int], k: Int): PriorityQueue[Int] = {
    val heap = PriorityQueue[Int]()(MaxHeapOrdering)
    for (a <- array) {
      if (heap.size < k) {
        heap.enqueue(a)
      } else if (a < heap.head) {
        heap.dequeue()
        heap.enqueue(a)
      }
    }
    heap
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 5, 2, 9, -1, 11, 6, 13, 15)
    val smallest = smallestK(array, 3)
    println(smallest.mkString(", "))
  }
}
