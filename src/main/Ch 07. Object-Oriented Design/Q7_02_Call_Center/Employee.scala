package Q7_02_Call_Center

abstract class Employee(protected val callHandler: CallHandler) {
  private var currentCall: Option[Call] = None
  protected var rank: Rank = _

  // Start the conversation
  def receiveCall(call: Call): Unit = {
    currentCall = Some(call)
  }

  // The issue is resolved, finish the call
  def callCompleted(): Unit = {
    currentCall.foreach { call =>
      // Disconnect the call
      call.disconnect()

      // Free the employee
      currentCall = None
    }

    // Check if there is a call waiting in queue
    assignNewCall()
  }

  // The issue has not been resolved. Escalate the call, and assign a new call to the employee
  def escalateAndReassign(): Unit = {
    currentCall.foreach { call =>
      // escalate call
      call.incrementRank()
      callHandler.dispatchCall(call)

      // free the employee
      currentCall = None
    }

    // assign a new call
    assignNewCall()
  }

  // Assign a new call to an employee, if the employee is free
  def assignNewCall(): Boolean = {
    if (!isFree) return false
    callHandler.assignCall(this)
  }

  // Returns whether or not the employee is free
  def isFree: Boolean = currentCall.isEmpty

  def getRank: Rank = rank
}
