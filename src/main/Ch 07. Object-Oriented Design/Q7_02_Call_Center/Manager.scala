package Q7_02_Call_Center

class Manager(callHandler: CallHandler) extends Employee(callHandler) {
  rank = Rank.Manager
}
