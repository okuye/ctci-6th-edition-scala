package Q17_17_Multi_Search

import scala.collection.mutable

object QuestionB {

  def subtractValue(locations: mutable.Buffer[Int], delta: Int): Unit = {
    if (locations == null) return
    for (i <- locations.indices) {
      locations(i) -= delta
    }
  }

  def createTrieFromString(s: String): Trie = {
    val trie = new Trie()
    for (i <- s.indices) {
      val suffix = s.substring(i)
      trie.insertString(suffix, i)
    }
    trie
  }

  def searchAll(
      big: String,
      smalls: Array[String]
  ): mutable.HashMap[String, mutable.Buffer[Int]] = {
    val lookup = mutable.HashMap[String, mutable.Buffer[Int]]()
    val tree = createTrieFromString(big)
    for (s <- smalls) {
      tree.search(s) match {
        case Some(seq) =>
          val locations = seq.toBuffer
          subtractValue(locations, s.length)
          lookup.put(s, locations)
        case None => // Do nothing
      }
    }

    lookup
  }

  def main(args: Array[String]): Unit = {
    val big = "mississippi"
    val smalls = Array("is", "ppi", "hi", "sis", "i", "mississippi")
    val locations = searchAll(big, smalls)
    println(locations)
  }
}
