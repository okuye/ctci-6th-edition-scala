package Q7_11_File_System

class File(n: String, p: Option[Directory], sz: Int) extends Entry(n, p) {
  private var content: String = _
  private var _size: Int = sz

  override def size(): Int = _size

  def getContents: String = content

  def setContents(c: String): Unit = {
    content = c
  }
}
