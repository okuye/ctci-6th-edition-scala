package Q7_07_Chat_Server

import scala.collection.mutable
import java.util.Date

class User(val id: Int, val accountName: String, val fullName: String) {
  private var status: Option[UserStatus] = None
  private val privateChats = mutable.HashMap[Int, PrivateChat]()
  private val groupChats = mutable.ListBuffer[GroupChat]()
  private val receivedAddRequests = mutable.HashMap[Int, AddRequest]()
  private val sentAddRequests = mutable.HashMap[Int, AddRequest]()
  private val contacts = mutable.HashMap[Int, User]()

  def sendMessageToUser(toUser: User, content: String): Boolean = {
    var chat = privateChats.getOrElse(toUser.id, null)
    if (chat == null) {
      chat = new PrivateChat(this, toUser)
      privateChats += (toUser.id -> chat)
    }
    val message = new Message(content, new Date())
    chat.addMessage(message)
  }

  def sendMessageToGroupChat(groupId: Int, content: String): Boolean = {
    val chat = groupChats.find(_.getId == groupId)
    chat match {
      case Some(groupChat) =>
        val message = new Message(content, new Date())
        groupChat.addMessage(message)
        true
      case None => false
    }
  }

  def setStatus(newStatus: UserStatus): Unit = {
    status = Some(newStatus)
  }

  def getStatus: Option[UserStatus] = status

  def addContact(user: User): Boolean = {
    if (contacts.contains(user.id)) {
      false
    } else {
      contacts += (user.id -> user)
      true
    }
  }

  def receivedAddRequest(req: AddRequest): Unit = {
    val senderId = req.fromUser.id
    if (!receivedAddRequests.contains(senderId)) {
      receivedAddRequests += (senderId -> req)
    }
  }

  def sentAddRequest(req: AddRequest): Unit = {
    val receiverId = req.toUser.id
    if (!sentAddRequests.contains(receiverId)) {
      sentAddRequests += (receiverId -> req)
    }
  }

  def removeAddRequest(req: AddRequest): Unit = {
    if (req.toUser == this) {
      receivedAddRequests -= req.fromUser.id
    } else if (req.fromUser == this) {
      sentAddRequests -= req.toUser.id
    }
  }

  def requestAddUser(accountName: String): Unit = {
    UserManager.addUser(this, accountName)
  }

  def addConversation(conversation: PrivateChat): Unit = {
    conversation.getOtherParticipant(this) match {
      case Some(otherUser) => privateChats(otherUser.id) = conversation
      case None => // Handle the case where there's no other participant
    }
  }

  def addConversation(conversation: GroupChat): Unit = {
    groupChats += conversation
  }
}
