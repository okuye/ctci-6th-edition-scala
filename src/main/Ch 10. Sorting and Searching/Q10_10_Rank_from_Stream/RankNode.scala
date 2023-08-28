package Q10_10_Rank_from_Stream

class RankNode(d: Int) {
  var left_size: Int = 0
  var left: RankNode = _
  var right: RankNode = _
  val data: Int = d

  def insert(d: Int): Unit = {
    if (d <= data) {
      if (left != null) {
        left.insert(d)
      } else {
        left = new RankNode(d)
      }
      left_size += 1
    } else {
      if (right != null) {
        right.insert(d)
      } else {
        right = new RankNode(d)
      }
    }
  }

  def getRank(d: Int): Int = {
    if (d == data) {
      left_size
    } else if (d < data) {
      if (left == null) -1 else left.getRank(d)
    } else {
      val right_rank = if (right == null) -1 else right.getRank(d)
      if (right_rank == -1) -1 else left_size + 1 + right_rank
    }
  }
}
