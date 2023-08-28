package Q7_07_Chat_Server

object UserStatusType extends Enumeration {
  val Offline, Away, Idle, Available, Busy = Value
}

class UserStatus(val statusType: UserStatusType.Value, val message: String) {
  def getStatusType: UserStatusType.Value = statusType
  def getMessage: String = message
}
