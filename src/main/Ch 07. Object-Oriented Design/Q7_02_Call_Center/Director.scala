package Q7_02_Call_Center

class Director(callHandler: CallHandler) extends Employee(callHandler) {
  rank = Rank.Director
}
