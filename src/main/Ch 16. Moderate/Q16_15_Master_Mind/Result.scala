package Q16_15_Master_Mind

case class Result(hits: Int, pseudoHits: Int) {
  override def toString: String = s"Result [hits=$hits, pseudoHits=$pseudoHits]"
}
