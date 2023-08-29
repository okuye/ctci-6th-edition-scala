package Q17_17_Multi_Search

class Trie {
  private val root = new TrieNode()

  def search(s: String): Option[Seq[Int]] = {
    root.search(s)
  }

  def insertString(str: String, location: Int): Unit = {
    root.insertString(str, location)
  }

  def getRoot: TrieNode = {
    root
  }
}
