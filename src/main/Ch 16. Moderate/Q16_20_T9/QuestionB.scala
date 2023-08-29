package Q16_20_T9

import CtCILibrary.AssortedMethods
import CtCILibrary.Trie
import CtCILibrary.TrieNode
import scala.collection.mutable.ArrayBuffer

object QuestionB {
  val t9Letters: Array[Array[Char]] = Array(
    null, // 0
    null, // 1
    Array('a', 'b', 'c'), // 2
    Array('d', 'e', 'f'), // 3
    Array('g', 'h', 'i'), // 4
    Array('j', 'k', 'l'), // 5
    Array('m', 'n', 'o'), // 6
    Array('p', 'q', 'r', 's'), // 7
    Array('t', 'u', 'v'), // 8
    Array('w', 'x', 'y', 'z') // 9
  )

  def getT9Chars(digit: Char): Array[Char] = {
    if (!digit.isDigit) return null
    val dig = digit.asDigit
    t9Letters(dig)
  }

  def getValidWords(number: String, index: Int, prefix: String, trieNode: TrieNode, results: ArrayBuffer[String]): Unit = {
    if (index == number.length) {
      if (trieNode.terminates) {
        results += prefix
      }
      return
    }

    val digit = number(index)
    val letters = getT9Chars(digit)

    if (letters != null) {
      for (letter <- letters) {
        val child = trieNode.getChild(letter)
        if (child != null) {
          getValidWords(number, index + 1, prefix + letter, child, results)
        }
      }
    }
  }

  def getValidT9Words(number: String, trie: Trie): ArrayBuffer[String] = {
    val results = ArrayBuffer[String]()
    getValidWords(number, 0, "", trie.getRoot, results)
    results
  }

  def main(args: Array[String]): Unit = {
    val words = getValidT9Words("8733", AssortedMethods.getTrieDictionary)
    for (w <- words) {
      println(w)
    }
  }
}
