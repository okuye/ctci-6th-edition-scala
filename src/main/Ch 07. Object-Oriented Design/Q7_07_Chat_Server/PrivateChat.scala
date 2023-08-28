package Q7_07_Chat_Server

class PrivateChat(user1: User, user2: User) extends Conversation {
  participants += user1
  participants += user2

  def getOtherParticipant(primary: User): Option[User] = {
    if (participants.head == primary) {
      Some(participants(1))
    } else if (participants(1) == primary) {
      Some(participants.head)
    } else {
      None
    }
  }
}
