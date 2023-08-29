package Q16_19_Pond_Sizes

import scala.collection.mutable.ArrayBuffer

object QuestionA {

  def computePondSizes(land: Array[Array[Int]]): ArrayBuffer[Int] = {
    val pondSizes = ArrayBuffer[Int]()
    for (r <- land.indices; c <- land(r).indices) {
      if (land(r)(c) == 0) {
        val size = computeSize(land, r, c)
        pondSizes += size
      }
    }
    pondSizes
  }

  def computeSize(land: Array[Array[Int]], row: Int, col: Int): Int = {
    if (row < 0 || col < 0 || row >= land.length || col >= land(row).length || land(row)(col) != 0) {
      return 0
    }
    var size = 1
    land(row)(col) = -1
    for {
      dr <- -1 to 1
      dc <- -1 to 1
    } {
      size += computeSize(land, row + dr, col + dc)
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
