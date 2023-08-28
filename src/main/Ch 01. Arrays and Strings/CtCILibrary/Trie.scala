//package CtCILibrary
//
//class Trie(list: Seq[String]) {
//  private val root = new TrieNode()
//
//  list.foreach(word => root.addWord(word))
//
//  def contains(prefix: String, exact: Boolean = false): Boolean = {
//    var lastNode: TrieNode = root
//    for (ch <- prefix) {
//      lastNode = lastNode.getChild(ch)
//      if (lastNode == null) return false
//    }
//    !exact || lastNode.terminates()
//  }
//
//  def getRoot: TrieNode = root
//}
//
//object Trie {
//  def apply(list: Array[String]): Trie = new Trie(list)
//  def apply(list: java.util.ArrayList[String]): Trie = new Trie(list.toArray)
//}
package CtCILibrary

class Trie(list: Seq[String]) {
  private val root = new TrieNode()

  list.foreach(word => root.addWord(word))

  def contains(prefix: String, exact: Boolean = false): Boolean = {
    var lastNode: TrieNode = root
    for (ch <- prefix) {
      lastNode = lastNode.getChild(ch)
      if (lastNode == null) return false
    }
    !exact || lastNode.terminates // Assuming terminates is a property
  }

  def getRoot: TrieNode = root
}

object Trie {
  def apply(list: Array[String]): Trie = new Trie(list)
  def apply(list: java.util.ArrayList[String]): Trie = new Trie(
    list.toArray.asInstanceOf[Array[String]]
  )
}
