package Q7_11_File_System

import scala.collection.mutable.ArrayBuffer

//class Directory(n: String, p: Directory) extends Entry(n, p) {
class Directory(n: String, p: Option[Directory]) extends Entry(n, p) {
  private val contents = ArrayBuffer[Entry]()

  def getContents: ArrayBuffer[Entry] = contents

  override def size: Int = contents.map(_.size).sum

  def numberOfFiles: Int = {
    contents.foldLeft(0) {
      case (count, directory: Directory) => count + 1 + directory.numberOfFiles
      case (count, _: File) => count + 1
      case (count, _) => count
    }
  }

  def deleteEntry(entry: Entry): Boolean = {
    val initialSize = contents.size
    contents -= entry
    contents.size != initialSize
  }

  def addEntry(entry: Entry): Unit = {
    contents += entry
  }
}
