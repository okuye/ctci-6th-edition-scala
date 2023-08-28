package Q8_13_Stack_of_Boxes

import java.util.Comparator

import scala.collection.mutable.ArrayBuffer
import scala.math.Ordering


class BoxComparator extends Ordering[Box] {
  override def compare(x: Box, y: Box): Int = {
    y.height - x.height
  }
}

