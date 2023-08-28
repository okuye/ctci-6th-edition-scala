package Q7_05_Online_Book_Reader

import scala.collection.mutable

class UserManager {
  private val users: mutable.Map[Int, User] = mutable.Map[Int, User]()

  def addUser(id: Int, details: String, accountType: Int): Option[User] = {
    if (users.contains(id)) {
      None
    } else {
      val user = new User(id, details, accountType)
      users(id) = user
      Some(user)
    }
  }

  def remove(u: User): Boolean = {
    remove(u.getID)
  }

  def remove(id: Int): Boolean = {
    if (!users.contains(id)) {
      false
    } else {
      users -= id
      true
    }
  }

  def find(id: Int): Option[User] = {
    users.get(id)
  }
}
