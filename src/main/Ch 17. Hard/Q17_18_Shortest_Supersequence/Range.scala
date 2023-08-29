package Q17_18_Shortest_Supersequence

case class Range(start: Int, end: Int) {

  def length: Int = end - start + 1

  override def toString: String = s"Range [start=$start, end=$end]"

  def shorterThan(other: Range): Boolean = length < other.length
}
