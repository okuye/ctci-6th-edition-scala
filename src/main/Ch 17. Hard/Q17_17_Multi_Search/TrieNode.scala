package Q17_17_Multi_Search

import scala.collection.mutable

class TrieNode {
  private val children = mutable.HashMap[Char, TrieNode]()
  private val indexes = mutable.ArrayBuffer[Int]()

  def insertString(s: String, index: Int): Unit = {
    if (s != null) {
      indexes.append(index)
      if (s.nonEmpty) {
        val value = s.head
        val child = children.getOrElseUpdate(value, new TrieNode())
        val remainder = s.tail
        child.insertString(remainder, index + 1)
      } else {
        children.put('\u0000', null)
      }
    }
  }

  def search(s: String): Option[Seq[Int]] = {
    if (s == null || s.isEmpty) {
      Some(indexes.toSeq)
    } else {
      val first = s.head
      val remainder = s.tail
      children.get(first).flatMap(child => child.search(remainder))
    }
  }

  def terminates(): Boolean = {
    children.contains('\u0000')
  }

  def getChild(c: Char): Option[TrieNode] = {
    children.get(c)
  }
}
