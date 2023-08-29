package Q17_18_Shortest_Supersequence

import scala.collection.mutable

object QuestionE {

  class CountedLookup(array: Array[Int]) {
    private val lookup = mutable.Map[Int, Int]()
    private var fulfilled = 0

    array.foreach(a => lookup(a) = 0)

    def contains(v: Int): Boolean = lookup.contains(v)

    def incrementIfFound(v: Int): Unit = {
      if (contains(v)) {
        lookup(v) = lookup.getOrElse(v, 0) + 1
        if (lookup(v) == 1) fulfilled += 1
      }
    }

    def decrementIfFound(v: Int): Unit = {
      if (contains(v)) {
        lookup(v) = lookup.getOrElse(v, 0) - 1
        if (lookup(v) == 0) fulfilled -= 1
      }
    }

    def areAllFulfilled: Boolean = fulfilled == lookup.size
  }

  def shortestSupersequence(big: Array[Int], small: Array[Int]): Option[Range] = {
    if (big.length < small.length) return None

    val countedLookup = new CountedLookup(small)
    var best: Option[Range] = None
    var right = 0
    countedLookup.incrementIfFound(big(0))

    for (left <- big.indices) {
      right = findClosure(big, right, countedLookup)
      if (!countedLookup.areAllFulfilled) return best

      val length = right - left + 1
      best match {
        case Some(r) if r.length > length => best = Some(Range(left, right))
        case None => best = Some(Range(left, right))
        case _ => // do nothing
      }

      countedLookup.decrementIfFound(big(left))
    }

    best
  }

  def findClosure(big: Array[Int], startIndex: Int, countedLookup: CountedLookup): Int = {
    var index = startIndex
    while (!countedLookup.areAllFulfilled && index + 1 < big.length) {
      index += 1
      countedLookup.incrementIfFound(big(index))
    }
    index
  }

  def main(args: Array[String]): Unit = {
    val array = Array(7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7)
    val set = Array(1, 5, 9)

    val shortest = shortestSupersequence(array, set)
    shortest match {
      case None => println("not found")
      case Some(r) =>
        println(r)
        for (i <- r.start to r.end) print(s"${array(i)}, ")
    }
  }
}
