package Q17_22_Word_Transformer

package Q17_22_Word_Transformer

import scala.collection.mutable
import scala.collection.immutable.Queue

class BFSData(root: String) {
  val toVisit: Queue[PathNode] = Queue(PathNode(root, null))
  val visited: mutable.HashMap[String, PathNode] = mutable.HashMap(root -> toVisit.head)

  def isFinished: Boolean = toVisit.isEmpty
}


object Tester {
  def main(args: Array[String]): Unit = {
    val tests: Array[Array[String]] = Array(
      Array("6 1 8 1 2 1 5", "16"),
      Array("5 1 2 1 8", "11"),
      Array("15 12 20 16 17 25", "10"),
      Array("28 25 26", "1"),
      Array("28 25 28", "3"),
      Array("22", "0"),
      Array("22 22", "0"),
      Array("0 0 4 0 0 6 0 0 3 0 8 0 2 0 5 2 0 3 0 0", "46")
    )

    for (test <- tests) {
      val input: String = test(0)
      val output: String = test(1)
      val inputStringArray: Array[String] = input.split(" ")
      val histogram: Array[Int] = inputStringArray.map(_.toInt)
      val targetVolume: Int = output.toInt

      val volumeA: Int = QuestionA.computeHistogramVolume(histogram)
      val volumeB: Int = QuestionB.computeHistogramVolume(histogram)
      val volumeC: Int = QuestionC.computeHistogramVolume(histogram)

      if (volumeA != targetVolume || volumeB != targetVolume || volumeC != targetVolume) {
        println(s"FAILURE: $input -> wanted $output but got ($volumeA, $volumeB, $volumeC)")
      } else {
        println(s"SUCCESS: $input -> $targetVolume")
      }
    }
  }
}
