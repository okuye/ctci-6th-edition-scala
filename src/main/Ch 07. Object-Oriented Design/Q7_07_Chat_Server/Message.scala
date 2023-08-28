package Q7_07_Chat_Server

import java.util.Date

class Message(private val content: String, private val date: Date) {
  def getContent: String = content
  def getDate: Date = date
}
