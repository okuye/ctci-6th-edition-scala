package Q17_25_Word_Rectangle

import CtCILibrary.Trie

class Rectangle(val length: Int, val height: Int, val matrix: Array[Array[Char]]) {

  def getLetter(i: Int, j: Int): Char = matrix(i)(j)

  def getColumn(i: Int): String = {
    val column = new Array[Char](height)
    for (j <- 0 until height) {
      column(j) = getLetter(j, i)
    }
    new String(column)
  }

  def isComplete(l: Int, h: Int, groupList: WordGroup): Boolean = {
    if (height == h) {
      for (i <- 0 until l) {
        val col = getColumn(i)
        if (!groupList.containsWord(col)) {
          return false
        }
      }
      true
    } else {
      false
    }
  }

  def isPartialOK(l: Int, trie: Trie): Boolean = {
    if (height == 0) {
      true
    } else {
      for (i <- 0 until l) {
        val col = getColumn(i)
        if (!trie.contains(col)) {
          return false
        }
      }
      true
    }
  }

  def append(s: String): Rectangle = {
    if (s.length == length) {
      val temp = Array.ofDim[Char](height + 1, length)
      for (i <- 0 until height) {
        for (j <- 0 until length) {
          temp(i)(j) = matrix(i)(j)
        }
      }
      s.getChars(0, length, temp(height), 0)
      new Rectangle(length, height + 1, temp)
    } else {
      null
    }
  }

  def print(): Unit = {
    for (i <- 0 until height) {
      for (j <- 0 until length) {
        print(matrix(i)(j))
      }
      println(" ")
    }
  }
}
