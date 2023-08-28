package Q7_07_Chat_Server

import scala.collection.mutable
import java.util.Date

object UserManager {
  private val usersById = mutable.HashMap[Int, User]()
  private val usersByAccountName = mutable.HashMap[String, User]()
  private val onlineUsers = mutable.HashMap[Int, User]()

  def addUser(fromUser: User, toAccountName: String): Unit = {
    val toUser = usersByAccountName.getOrElse(toAccountName, null)
    if (toUser != null) {
      val req = new AddRequest(fromUser, toUser, new Date())
      toUser.receivedAddRequest(req)
      fromUser.sentAddRequest(req)
    }
  }

  def approveAddRequest(req: AddRequest): Unit = {
    req.status = RequestStatus.Accepted
    val from = req.fromUser
    val to = req.toUser
    from.addContact(to)
    to.addContact(from)
  }

  def rejectAddRequest(req: AddRequest): Unit = {
    req.status = RequestStatus.Rejected
    val from = req.fromUser
    val to = req.toUser
    from.removeAddRequest(req)
    to.removeAddRequest(req)
  }

  def userSignedOn(accountName: String): Unit = {
    val user = usersByAccountName.getOrElse(accountName, null)
    if (user != null) {
      user.setStatus(new UserStatus(UserStatusType.Available, ""))
      onlineUsers += (user.id -> user)
    }
  }

  def userSignedOff(accountName: String): Unit = {
    val user = usersByAccountName.getOrElse(accountName, null)
    if (user != null) {
      user.setStatus(new UserStatus(UserStatusType.Offline, ""))
      onlineUsers -= user.id
    }
  }
}
