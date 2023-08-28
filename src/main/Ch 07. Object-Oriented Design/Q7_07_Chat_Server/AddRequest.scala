package Q7_07_Chat_Server

import java.util.Date

class AddRequest(val fromUser: User, val toUser: User, val date: Date) {
  var status: RequestStatus.Value = RequestStatus.Unread
}
