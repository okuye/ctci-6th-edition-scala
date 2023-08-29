package Q17_20_Continuous_Median

import scala.collection.mutable.PriorityQueue
import scala.math.Ordering

object Question {
  private val maxHeapComparator: Ordering[Int] = Ordering[Int].reverse
  private val minHeapComparator: Ordering[Int] = Ordering[Int]
  private val maxHeap: PriorityQueue[Int] = PriorityQueue.empty(maxHeapComparator)
  private val minHeap: PriorityQueue[Int] = PriorityQueue.empty(minHeapComparator)

  def addNewNumber(randomNumber: Int): Unit = {
    if (maxHeap.size == minHeap.size) {
      if (minHeap.nonEmpty && randomNumber > minHeap.head) {
        maxHeap.enqueue(minHeap.dequeue())
        minHeap.enqueue(randomNumber)
      } else {
        maxHeap.enqueue(randomNumber)
      }
    } else {
      if (randomNumber < maxHeap.head) {
        minHeap.enqueue(maxHeap.dequeue())
        maxHeap.enqueue(randomNumber)
      } else {
        minHeap.enqueue(randomNumber)
      }
    }
  }

  def getMedian: Double = {
    if (maxHeap.isEmpty) {
      0
    } else if (maxHeap.size == minHeap.size) {
      (minHeap.head.toDouble + maxHeap.head.toDouble) / 2
    } else {
      maxHeap.head.toDouble
    }
  }

  def addNewNumberAndPrintMedian(randomNumber: Int): Unit = {
    addNewNumber(randomNumber)
    println(s"Random Number = $randomNumber")
    printMinHeapAndMaxHeap()
    println(s"\nMedian = ${getMedian}\n")
  }

  def printMinHeapAndMaxHeap(): Unit = {
    val minHeapArray: Array[Int] = minHeap.clone().dequeueAll.toArray
    val maxHeapArray: Array[Int] = maxHeap.clone().dequeueAll.toArray

    scala.util.Sorting.quickSort(minHeapArray)(maxHeapComparator)
    scala.util.Sorting.quickSort(maxHeapArray)(maxHeapComparator)

    print("MinHeap =")
    for (i <- minHeapArray.indices.reverse) {
      print(s" ${minHeapArray(i)}")
    }
    print("\nMaxHeap =")
    for (i <- maxHeapArray.indices) {
      print(s" ${maxHeapArray(i)}")
    }
  }

  def main(args: Array[String]): Unit = {
    val arraySize = 10
    val range = 7

    for (_ <- 0 until arraySize) {
      val randomNumber = (math.random() * (range + 1)).toInt
      addNewNumberAndPrintMedian(randomNumber)
    }
  }
}
