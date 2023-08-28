package Q7_03_Jukebox

class User(private var name: String, private var ID: Long) {

  def getName: String = name

  def setName(name: String): Unit = {
    this.name = name
  }

  def getID: Long = ID

  def setID(ID: Long): Unit = {
    this.ID = ID
  }

  def getUser: User = this
}

object User {
  def addUser(name: String, ID: Long): User = new User(name, ID)
}
