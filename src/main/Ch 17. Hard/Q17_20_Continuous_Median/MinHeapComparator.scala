package Q17_20_Continuous_Median

import java.util.Comparator

object MinHeapComparator extends Comparator[Int] {
  override def compare(o1: Int, o2: Int): Int = {
    if (o1 > o2) 1
    else if (o1 == o2) 0
    else -1
  }
}
