package Q17_18_Shortest_Supersequence

import scala.collection.mutable
import Q17_18_Shortest_Supersequence.HeapNode

object QuestionD {


  def getShortestClosure(lists: Seq[mutable.Queue[Int]]): Option[Range] = {
    val minHeap = mutable.PriorityQueue[HeapNode]()(Ordering.by(_.locationWithinList).reverse)
    var max = Int.MinValue

    for (i <- lists.indices) {
      val list = lists(i)
      if (list.isEmpty) return None
      val head = list.dequeue()
      minHeap += HeapNode(head, i)
      max = Math.max(max, head)
    }

    val minNode = minHeap.head
    var bestRangeMin = minNode.locationWithinList
    var bestRangeMax = max

    while (minHeap.nonEmpty) {
      val n = minHeap.dequeue()
      val list = lists(n.listId)

      val min = n.locationWithinList
      if (max - min < bestRangeMax - bestRangeMin) {
        bestRangeMax = max
        bestRangeMin = min
      }

      if (list.nonEmpty) {
        val next = list.dequeue()
        minHeap += n.copy(locationWithinList = next)
        max = Math.max(max, next)
      } else {
        return Some(Range(bestRangeMin, bestRangeMax))
      }
    }

    Some(Range(bestRangeMin, bestRangeMax))
  }

  def getLocationsForElements(big: Array[Int], small: Array[Int]): Seq[mutable.Queue[Int]] = {
    val itemLocations = mutable.Map[Int, mutable.Queue[Int]]()
    for (s <- small) itemLocations(s) = mutable.Queue[Int]()

    for (i <- big.indices) {
      itemLocations.get(big(i)).foreach(_.enqueue(i))
    }

    itemLocations.values.toSeq
  }

  def shortestSupersequence(big: Array[Int], small: Array[Int]): Option[Range] = {
    val locations = getLocationsForElements(big, small)
    getShortestClosure(locations)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7)
    val set = Array(1, 5, 9)

    println(array.length)

    shortestSupersequence(array, set) match {
      case None => println("not found")
      case Some(range) => println(s"${range.start}, ${range.end}")
    }
  }

}
