package CtCILibrary

import scala.collection.mutable.HashMap

class TrieNode() {
  private val children = HashMap[Char, TrieNode]()
  private var _terminates = false
  private var character: Char = _

  def this(character: Char) {
    this()
    this.character = character
  }

  def getChar: Char = character

  def addWord(word: String): Unit = {
    if (word == null || word.isEmpty) return

    val firstChar = word.head
    var child = getChild(firstChar)

    if (child == null) {
      child = new TrieNode(firstChar)
      children(firstChar) = child
    }

    if (word.length > 1) {
      child.addWord(word.tail)
    } else {
      child.setTerminates(true)
    }
  }

  def getChild(c: Char): TrieNode = children.getOrElse(c, null)

  def terminates: Boolean = _terminates

  def setTerminates(t: Boolean): Unit = {
    _terminates = t
  }
}
