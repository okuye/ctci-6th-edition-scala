package Q17_25_Word_Rectangle

import CtCILibrary.AssortedMethods
import CtCILibrary.Trie

class Question(list: Array[String]) {

  private val maxWordLength: Int = list.map(_.length).max
  private val groupList: Array[WordGroup] = WordGroup.createWordGroups(list)
  private val trieList: Array[Trie] = new Array[Trie](maxWordLength)

  for (i <- 0 until maxWordLength) {
    if (groupList(i) != null) {
      val words = groupList(i).getWords()
      trieList(i) = new Trie(words)
    }
  }

  def maxRectangle(): Rectangle = {
    val maxSize = maxWordLength * maxWordLength

    for (z <- maxSize until 0 by -1) {
      for (i <- 1 to maxWordLength) {
        if (z % i == 0) {
          val j = z / i
          if (j <= maxWordLength) {
            val rectangle = makeRectangle(i, j)
            if (rectangle != null) {
              return rectangle
            }
          }
        }
      }
    }
    null
  }

  private def makeRectangle(length: Int, height: Int): Rectangle = {
    if (groupList(length - 1) == null || groupList(height - 1) == null) {
      null
    } else {
      if (trieList(height - 1) == null) {
        val words = groupList(height - 1).getWords()
        trieList(height - 1) = new Trie(words)
      }
      makePartialRectangle(length, height, new Rectangle(length))
    }
  }

  private def makePartialRectangle(l: Int, h: Int, rectangle: Rectangle): Rectangle = {
    if (rectangle.height == h) {
      if (rectangle.isComplete(l, h, groupList(h - 1))) {
        rectangle
      } else {
        null
      }
    } else if (!rectangle.isPartialOK(l, trieList(h - 1))) {
      null
    } else {
      for (i <- 0 until groupList(l - 1).length()) {
        val orgPlus = rectangle.append(groupList(l - 1).getWord(i))
        val rect = makePartialRectangle(l, h, orgPlus)
        if (rect != null) {
          return rect
        }
      }
      null
    }
  }
}

object Question {
  def main(args: Array[String]): Unit = {
    val dict = new Question(AssortedMethods.getListOfWords())
    val rect = dict.maxRectangle()
    if (rect != null) {
      rect.print()
    } else {
      println("No rectangle exists")
    }
  }
}
