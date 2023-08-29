package Q17_17_Multi_Search

import scala.collection.mutable

object QuestionC {
  def createTreeFromStrings(smalls: Array[String], maxSize: Int): Trie = {
    val tree = new Trie()
    for (s <- smalls) {
      if (s.length <= maxSize) {
        tree.insertString(s, 0)
      }
    }
    tree
  }

  def findStringsAtLoc(root: TrieNode, big: String, start: Int): Seq[String] = {
    val strings = mutable.ArrayBuffer[String]()
    var index = start
    var currentNodeOption: Option[TrieNode] = Some(root)

    while (index < big.length) {
      currentNodeOption = currentNodeOption.flatMap(_.getChild(big(index)))

      currentNodeOption match {
        case Some(currentNode) =>
          if (currentNode.terminates()) {
            strings.append(big.substring(start, index + 1))
          }
        case None => return strings.toSeq
      }

      index += 1
    }
    strings.toSeq // Convert ArrayBuffer to Seq
  }

  def insertIntoHashMap(
      strings: Seq[String],
      map: mutable.HashMap[String, mutable.ArrayBuffer[Int]],
      index: Int
  ): Unit = {
    for (s <- strings) {
      val list = map.getOrElseUpdate(s, mutable.ArrayBuffer())
      list.append(index)
    }
  }

  def searchAll(
      big: String,
      smalls: Array[String]
  ): mutable.HashMap[String, mutable.ArrayBuffer[Int]] = {
    val lookup = mutable.HashMap[String, mutable.ArrayBuffer[Int]]()
    val root = createTreeFromStrings(smalls, big.length).getRoot

    for (i <- big.indices) {
      val strings = findStringsAtLoc(root, big, i)
      insertIntoHashMap(strings, lookup, i)
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
