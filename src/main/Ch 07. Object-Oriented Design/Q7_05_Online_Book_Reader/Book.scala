package Q7_05_Online_Book_Reader

class Book(private var bookId: Int, private var details: String) {

  def update(): Unit = {}

  def getID: Int = bookId

  def setID(id: Int): Unit = {
    bookId = id
  }

  def getDetails: String = details

  def setDetails(details: String): Unit = {
    this.details = details
  }
}
