package Q17_18_Shortest_Supersequence

case class HeapNode(locationWithinList: Int, listId: Int)

object HeapNode {
  implicit val ordering: Ordering[HeapNode] = Ordering.by(_.locationWithinList)
}