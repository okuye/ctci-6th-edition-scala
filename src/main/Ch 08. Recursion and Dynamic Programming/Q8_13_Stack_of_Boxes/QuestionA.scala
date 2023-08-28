package Q8_13_Stack_of_Boxes

import scala.collection.mutable.ArrayBuffer

object QuestionA {
  implicit val boxOrdering: Ordering[Box] = new BoxComparator()

  def createStack(boxes: ArrayBuffer[Box]): Int = {
    val sortedBoxes = boxes.sorted
    var maxHeight = 0
    for (i <- 0 until sortedBoxes.size) {
      val height = createStack(sortedBoxes, i)
      maxHeight = Math.max(maxHeight, height)
    }
    maxHeight
  }

  def createStack(boxes: ArrayBuffer[Box], bottomIndex: Int): Int = {
    val bottom = boxes(bottomIndex)
    var maxHeight = 0
    for (i <- bottomIndex + 1 until boxes.size) {
      if (boxes(i).canBeAbove(bottom)) {
        val height = createStack(boxes, i)
        maxHeight = Math.max(height, maxHeight)
      }
    }
    maxHeight += bottom.height
    maxHeight
  }

  def main(args: Array[String]): Unit = {
    val boxList = Array(
      new Box(6, 4, 4),
      new Box(8, 6, 2),
      new Box(5, 3, 3),
      new Box(7, 8, 3),
      new Box(4, 2, 2),
      new Box(9, 7, 3)
    )
    val boxes = ArrayBuffer.empty[Box]
    boxList.foreach(boxes += _)

    val height = createStack(boxes)
    println(height)
  }
}

//object QuestionA {
//  implicit val boxOrdering: Ordering[Box] = new BoxComparator()
//
//  def createStack(boxes: ArrayBuffer[Box]): Int = {
//    val sortedBoxes = boxes.sorted
//    var maxHeight = 0
//    for (i <- 0 until sortedBoxes.size) {
//      val height = createStack(sortedBoxes, i)
//      maxHeight = Math.max(maxHeight, height)
//    }
//    maxHeight
//  }
//
//  def createStack(boxes: ArrayBuffer[Box], bottomIndex: Int): Int = {
//    val bottom = boxes(bottomIndex)
//    var maxHeight = 0
//    for (i <- bottomIndex + 1 until boxes.size) {
//      if (boxes(i).canBeAbove(bottom)) {
//        val height = createStack(boxes, i)
//        maxHeight = Math.max(height, maxHeight)
//      }
//    }
//    maxHeight += bottom.height
//    maxHeight
//  }
//
//  def main(args: Array[String]): Unit = {
//    val boxList = Array(
//      new Box(6, 4, 4),
//      new Box(8, 6, 2),
//      new Box(5, 3, 3),
//      new Box(7, 8, 3),
//      new Box(4, 2, 2),
//      new Box(9, 7, 3)
//    )
//    val boxes = ArrayBuffer.empty[Box]
//    boxList.foreach(boxes += _)
//
//    val height = createStack(boxes)
//    println(height)
//  }
//}
