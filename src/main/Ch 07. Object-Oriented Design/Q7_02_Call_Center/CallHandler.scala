package Q7_02_Call_Center

sealed trait Rank
object Rank {
  case object Responder extends Rank
  case object Manager extends Rank
  case object Director extends Rank

  val values = List(Responder, Manager, Director)
}

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

import scala.collection.mutable

class CallHandler {
  private val LEVELS = 3
  private val NUM_RESPONDENTS = 10
  private val NUM_MANAGERS = 4
  private val NUM_DIRECTORS = 2

  private val employeeLevels: mutable.ArrayBuffer[mutable.Buffer[Employee]] = mutable.ArrayBuffer.fill(LEVELS)(mutable.Buffer[Employee]())
  private val callQueues: mutable.ArrayBuffer[mutable.Queue[Call]] = mutable.ArrayBuffer.fill(LEVELS)(mutable.Queue[Call]())

  // Create respondents.
  for (_ <- 0 until NUM_RESPONDENTS) {
    employeeLevels(0) += new Respondent(this)
  }

  // Create managers.
  for (_ <- 0 until NUM_MANAGERS) {
    employeeLevels(1) += new Manager(this)
  }

  // Create directors.
  for (_ <- 0 until NUM_DIRECTORS) {
    employeeLevels(2) += new Director(this)
  }

  def getHandlerForCall(call: Call): Option[Employee] = {
    for (level <- Rank.values.indexOf(call.getRank) until LEVELS) {
      for (emp <- employeeLevels(level)) {
        if (emp.isFree) {
          return Some(emp)
        }
      }
    }
    None
  }

  def dispatchCall(caller: Caller): Unit = {
    val call = new Call(caller)
    dispatchCall(call)
  }

  def dispatchCall(call: Call): Unit = {
    getHandlerForCall(call) match {
      case Some(emp) =>
        emp.receiveCall(call)
        call.setHandler(emp)
      case None =>
        call.reply("Please wait for free employee to reply")
//        callQueues(call.getRank.getValue).enqueue(call)
        callQueues(Rank.values.indexOf(call.getRank)).enqueue(call)

    }
  }

  def assignCall(emp: Employee): Boolean = {
    for (rank <- Rank.values.indexOf(emp.getRank) to 0 by -1) {
      if (callQueues(rank).nonEmpty) {
        val call = callQueues(rank).dequeue()
        emp.receiveCall(call)
        return true
      }
    }
    false
  }
}
