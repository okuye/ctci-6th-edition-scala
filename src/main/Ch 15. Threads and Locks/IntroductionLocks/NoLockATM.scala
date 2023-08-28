package IntroductionLocks

class NoLockATM {
  private var balance: Int = 100

  def withdraw(value: Int): Int = {
    var temp = balance
    try {
      Thread.sleep(300)
      temp = temp - value
      Thread.sleep(300)
      balance = temp
    } catch {
      case e: InterruptedException =>
    }
    temp
  }

  def deposit(value: Int): Int = {
    var temp = balance
    try {
      Thread.sleep(300)
      temp = temp + value
      Thread.sleep(300)
      balance = temp
    } catch {
      case e: InterruptedException =>
    }
    temp
  }

  def getBalance: Int = balance
}
