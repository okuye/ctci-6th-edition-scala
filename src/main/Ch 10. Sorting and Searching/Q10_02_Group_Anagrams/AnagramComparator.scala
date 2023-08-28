package Q10_02_Group_Anagrams

import scala.math.Ordering

object AnagramComparator extends Ordering[String] {

  private def sortChars(s: String): String = {
    val content = s.toCharArray
    scala.util.Sorting.quickSort(content)
    new String(content)
  }

  override def compare(s1: String, s2: String): Int = {
    sortChars(s1).compareTo(sortChars(s2))
  }
}
