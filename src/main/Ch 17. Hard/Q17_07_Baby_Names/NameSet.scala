package Q17_07_Baby_Names

import scala.collection.mutable

class NameSet(name: String, freq: Int) {
  private val names = mutable.Set(name)
  private var frequency = freq
  private val rootName = name

  def getNames: Set[String] = names.toSet

  def getRootName: String = rootName

  def copyNamesWithFrequency(more: Set[String], freq: Int): Unit = {
    names ++= more
    frequency += freq
  }

  def getFrequency: Int = frequency

  def size: Int = names.size
}
