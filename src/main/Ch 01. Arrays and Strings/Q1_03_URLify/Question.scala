package Q1_03_URLify

import CtCILibrary.AssortedMethods

object Question {

  def replaceSpaces(str: Array[Char], trueLength: Int): Unit = {
    var spaceCount = 0
    for (i <- 0 until trueLength) {
      if (str(i) == ' ') {
        spaceCount += 1
      }
    }
    var index = trueLength + spaceCount * 2
    if (trueLength < str.length) str(trueLength) = '\u0000'
    for (i <- trueLength - 1 to 0 by -1) {
      if (str(i) == ' ') {
        str(index - 1) = '0'
        str(index - 2) = '2'
        str(index - 3) = '%'
        index -= 3
      } else {
        str(index - 1) = str(i)
        index -= 1
      }
    }
  }

  def findLastCharacter(str: Array[Char]): Int = {
    for (i <- str.length - 1 to 0 by -1) {
      if (str(i) != ' ') {
        return i
      }
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val str = "Mr John Smith    "
    val arr = str.toCharArray
    val trueLength = findLastCharacter(arr) + 1
    replaceSpaces(arr, trueLength)
    println("\"" + AssortedMethods.charArrayToString(arr) + "\"")
  }
}
