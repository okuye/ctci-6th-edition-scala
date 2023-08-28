package Q7_07_Chat_Server

class GroupChat extends Conversation {
  def removeParticipant(user: User): Unit = {
    participants -= user
  }

  def addParticipant(user: User): Unit = {
    participants += user
  }
}
