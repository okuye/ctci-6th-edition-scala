package Q10_10_Rank_from_Stream

import CtCILibrary.AssortedMethods

object Question {
  private var root: RankNode = _

  def track(number: Int): Unit = {
    if (root == null) {
      root = new RankNode(number)
    } else {
      root.insert(number)
    }
  }

  def getRankOfNumber(number: Int): Int = root.getRank(number)

  def main(args: Array[String]): Unit = {
    val size = 100
    val list = AssortedMethods.randomArray(size, -100, 100)
    list.foreach(track)

    val tracker = Array.fill(size)(0)
    list.indices.foreach { i =>
      val v = list(i)
      val rank1 = root.getRank(list(i))
      tracker(rank1) = v
    }

    tracker.indices.dropRight(1).foreach { i =>
      if (tracker(i) != 0 && tracker(i + 1) != 0 && tracker(i) > tracker(i + 1)) {
        println(s"ERROR at $i")
      }
    }

    println(s"Array: ${AssortedMethods.arrayToString(list)}")
    println(s"Ranks: ${AssortedMethods.arrayToString(tracker)}")
  }
}
