package Q8_13_Stack_of_Boxes

import java.util.ArrayList
import java.util.Collections

object QuestionB {
  def createStack(boxes: ArrayList[Box]): Int = {
    Collections.sort(boxes, new BoxComparator)
    var maxHeight = 0
    val stackMap = new Array[Int](boxes.size())
    for (i <- 0 until boxes.size()) {
      val height = createStack(boxes, i, stackMap)
      maxHeight = math.max(maxHeight, height)
    }
    maxHeight
  }

  def createStack(boxes: ArrayList[Box], bottomIndex: Int, stackMap: Array[Int]): Int = {
    if (bottomIndex < boxes.size() && stackMap(bottomIndex) > 0) {
      return stackMap(bottomIndex)
    }

    val bottom = boxes.get(bottomIndex)
    var maxHeight = 0
    for (i <- bottomIndex + 1 until boxes.size()) {
      if (boxes.get(i).canBeAbove(bottom)) {
        val height = createStack(boxes, i, stackMap)
        maxHeight = math.max(height, maxHeight)
      }
    }
    maxHeight += bottom.height
    stackMap(bottomIndex) = maxHeight
    maxHeight
  }

  def main(args: Array[String]): Unit = {
    val boxList = Array(new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3),
      new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3))
    val boxes = new ArrayList[Box]()
    for (b <- boxList) {
      boxes.add(b)
    }

    val height = createStack(boxes)
    println(height)
  }
}
