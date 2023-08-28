package Q7_02_Call_Center

class Call(c: Caller) {
  private var rank: Rank = Rank.Responder
  private val caller: Caller = c
  private var handler: Option[Employee] = None

  def setHandler(e: Employee): Unit = {
    handler = Some(e)
  }

  def reply(message: String): Unit = {
    println(message)
  }

  def getRank: Rank = rank

  def setRank(r: Rank): Unit = {
    rank = r
  }

  def incrementRank(): Rank = {
    rank match {
      case Rank.Responder => rank = Rank.Manager
      case Rank.Manager => rank = Rank.Director
      case _ => // Do nothing if it's already Director
    }
    rank
  }

  def disconnect(): Unit = {
    reply("Thank you for calling")
  }
}
