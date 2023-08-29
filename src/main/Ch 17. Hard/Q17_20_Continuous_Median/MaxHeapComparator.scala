package Q17_20_Continuous_Median

import scala.math.Ordering

object MaxHeapComparator extends Ordering[Int] {
  override def compare(x: Int, y: Int): Int = {
    if (x < y) 1
    else if (x == y) 0
    else -1
  }
}

