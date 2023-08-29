package Q16_20_T9

import CtCILibrary.AssortedMethods
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashSet

object QuestionA {
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

  def getValidWords(number: String, index: Int, prefix: String, wordSet: HashSet[String], results: ArrayBuffer[String]): Unit = {
    if (index == number.length) {
      if (wordSet.contains(prefix)) {
        results += prefix
      }
      return
    }

    val digit = number(index)
    val letters = getT9Chars(digit)

    if (letters != null) {
      for (letter <- letters) {
        getValidWords(number, index + 1, prefix + letter, wordSet, results)
      }
    }
  }

  def getValidT9Words(number: String, wordList: HashSet[String]): ArrayBuffer[String] = {
    val results = ArrayBuffer[String]()
    getValidWords(number, 0, "", wordList, results)
    results
  }

  def main(args: Array[String]): Unit = {
    val words = getValidT9Words("33835676368", AssortedMethods.getWordListAsHashSet())
    for (w <- words) {
      println(w)
    }
  }
}
