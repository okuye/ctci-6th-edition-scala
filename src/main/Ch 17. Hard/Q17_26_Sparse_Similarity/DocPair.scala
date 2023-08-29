package Q17_26_Sparse_Similarity

case class DocPair(doc1: Int, doc2: Int) {
  override def equals(obj: Any): Boolean = obj match {
    case p: DocPair => p.doc1 == doc1 && p.doc2 == doc2
    case _ => false
  }

  override def hashCode(): Int = (doc1 * 31) ^ doc2
}
