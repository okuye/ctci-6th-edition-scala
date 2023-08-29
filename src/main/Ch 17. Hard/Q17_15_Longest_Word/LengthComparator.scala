package Q17_15_Longest_Word

object LengthComparator extends Ordering[String] {
  def compare(o1: String, o2: String): Int = {
    if (o1.length < o2.length) 1
    else if (o1.length > o2.length) -1
    else 0
  }
}
