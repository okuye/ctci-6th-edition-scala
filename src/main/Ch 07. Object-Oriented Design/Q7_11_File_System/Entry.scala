package Q7_11_File_System

//abstract class Entry(val name: String, val parent: Option[Directory]) {
abstract class Entry(name: String, parent: Option[Directory]) {
  protected val created: Long = System.currentTimeMillis()
  protected var lastUpdated: Long = System.currentTimeMillis()
  protected var lastAccessed: Long = System.currentTimeMillis()

  def delete(): Boolean = {
    parent match {
      case Some(p) => p.deleteEntry(this)
      case None => false
    }
  }

  def size(): Int

  def getFullPath(): String = {
    parent match {
      case Some(p) => p.getFullPath + "/" + name
      case None => name
    }
  }

  def getCreationTime: Long = created

  def getLastUpdatedTime: Long = lastUpdated

  def getLastAccessedTime: Long = lastAccessed

  def changeName(n: String): Unit = {
    // Assuming you want to change the name here
    // Note: This will only work if `name` is a `var`, not a `val`
  }
}
