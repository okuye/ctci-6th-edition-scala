package Q16_19_Pond_Sizes

import scala.collection.mutable.ArrayBuffer

object QuestionB {

  def computePondSizes(land: Array[Array[Int]]): ArrayBuffer[Int] = {
    val visited = Array.ofDim[Boolean](land.length, land.head.length)
    val pondSizes = ArrayBuffer[Int]()
    for (r <- land.indices; c <- land(r).indices) {
      val size = computeSize(land, visited, r, c)
      if (size > 0) {
        pondSizes += size
      }
    }
    pondSizes
  }

  def computeSize(land: Array[Array[Int]], visited: Array[Array[Boolean]], row: Int, col: Int): Int = {
    if (row < 0 || col < 0 || row >= land.length || col >= land(row).length || visited(row)(col) || land(row)(col) != 0) {
      return 0
    }
    var size = 1
    visited(row)(col) = true
    for {
      dr <- -1 to 1
      dc <- -1 to 1
    } {
      size += computeSize(land, visited, row + dr, col + dc)
    }
    size
  }

  def main(args: Array[String]): Unit = {
    val land = Array(
      Array(0, 2, 1, 0),
      Array(0, 1, 0, 1),
      Array(1, 1, 0, 1),
      Array(0, 1, 0, 1)
    )
    val sizes = computePondSizes(land)
    for (sz <- sizes) {
      println(sz)
    }
  }
}
