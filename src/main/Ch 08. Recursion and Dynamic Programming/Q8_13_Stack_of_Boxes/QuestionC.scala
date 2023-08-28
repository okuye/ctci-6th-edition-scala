package Q8_13_Stack_of_Boxes

import java.util.ArrayList
import java.util.Collections

object QuestionC {
  def createStack(boxes: ArrayList[Box]): Int = {
    Collections.sort(boxes, new BoxComparator)
    val stackMap = new Array[Int](boxes.size())
    createStack(boxes, null, 0, stackMap)
  }

  def createStack(boxes: ArrayList[Box], bottom: Box, offset: Int, stackMap: Array[Int]): Int = {
    if (offset >= boxes.size()) {
      return 0
    }

    /* height with this bottom */
    val newBottom = boxes.get(offset)
    var heightWithBottom = 0
    if (bottom == null || newBottom.canBeAbove(bottom)) {
      if (stackMap(offset) == 0) {
        stackMap(offset) = createStack(boxes, newBottom, offset + 1, stackMap)
        stackMap(offset) += newBottom.height
      }
      heightWithBottom = stackMap(offset)
    }

    /* without this bottom */
    val heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap)

    math.max(heightWithBottom, heightWithoutBottom)
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
