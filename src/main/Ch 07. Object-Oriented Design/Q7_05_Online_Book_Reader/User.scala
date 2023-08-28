package Q7_05_Online_Book_Reader

class User(private var userId: Int, private var details: String, private var accountType: Int) {

  def renewMembership(): Unit = {}

  // getters
  def getID: Int = userId
  def getDetails: String = details
  def getAccountType: Int = accountType

  // setters
  def setID(id: Int): Unit = userId = id
  def setDetails(details: String): Unit = this.details = details
  def setAccountType(accountType: Int): Unit = this.accountType = accountType
}
