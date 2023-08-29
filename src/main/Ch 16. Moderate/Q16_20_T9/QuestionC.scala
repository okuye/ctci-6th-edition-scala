package Q16_20_T9

import CtCILibrary.AssortedMethods
import CtCILibrary.HashMapList
import scala.collection.mutable.{ArrayBuffer, HashMap}

object QuestionC {
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

  def convertToT9(
      word: String,
      letterToNumberMap: HashMap[Char, Char]
  ): String = {
    val sb = new StringBuilder
    for (c <- word) {
      letterToNumberMap.get(c).foreach(sb.append)
    }
    sb.toString()
  }

  def createLetterToNumberMap(): HashMap[Char, Char] = {
    val letterToNumberMap = HashMap[Char, Char]()
    for (i <- t9Letters.indices) {
      val letters = t9Letters(i)
      if (letters != null) {
        for (letter <- letters) {
          val c = Character.forDigit(i, 10)
          letterToNumberMap += letter -> c
        }
      }
    }
    letterToNumberMap
  }

  def initializeDictionary(
      words: Array[String]
  ): HashMapList[String, String] = {
    val letterToNumberMap = createLetterToNumberMap()
    val wordsToNumbers = new HashMapList[String, String]()
    for (word <- words) {
      val numbers = convertToT9(word, letterToNumberMap)
      wordsToNumbers.put(numbers, word)
    }
    wordsToNumbers
  }

  def getValidT9Words(
      numbers: String,
      dictionary: HashMapList[String, String]
  ): ArrayBuffer[String] = {
    dictionary.get(numbers) match {
      case Some(wordList) => wordList
      case None           => ArrayBuffer[String]()
    }
  }

  def main(args: Array[String]): Unit = {
    val dictionary = initializeDictionary(AssortedMethods.getListOfWords())
    val words = getValidT9Words("8733", dictionary)
    for (w <- words) {
      println(w)
    }
  }
}
