package Big_O

import scala.collection.mutable.ArrayBuffer

object Q_09 {
  def copyArray(array: Array[Int]): Array[Int] = {
    val copy = ArrayBuffer.empty[Int]
    for (value <- array) {
      copy.append(value)
    }
    copy.toArray
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6)
    val copy = copyArray(array)
    for (x <- copy) {
      println(x)
    }
  }
}
