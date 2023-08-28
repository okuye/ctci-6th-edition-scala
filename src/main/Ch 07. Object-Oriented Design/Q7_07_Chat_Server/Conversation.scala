package Q7_07_Chat_Server

import scala.collection.mutable.ArrayBuffer

abstract class Conversation {
  protected val participants: ArrayBuffer[User] = ArrayBuffer[User]()
  protected var id: Int = _
  protected val messages: ArrayBuffer[Message] = ArrayBuffer[Message]()

  def getMessages: ArrayBuffer[Message] = messages

  def addMessage(m: Message): Boolean = {
    messages += m
    true
  }

  def getId: Int = id
}
