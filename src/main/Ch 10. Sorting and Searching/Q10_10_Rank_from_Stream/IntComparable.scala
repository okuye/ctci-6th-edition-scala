package Q10_10_Rank_from_Stream

object IntComparable extends Ordering[Int] {
  override def compare(o1: Int, o2: Int): Int = o1.compare(o2)
}
