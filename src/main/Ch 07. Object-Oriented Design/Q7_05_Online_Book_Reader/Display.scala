package Q7_05_Online_Book_Reader

class Display {
  private var activeBook: Book = _
  private var activeUser: User = _
  private var pageNumber: Int = 0

  def displayUser(user: User): Unit = {
    activeUser = user
    refreshUsername()
  }

  def displayBook(book: Book): Unit = {
    pageNumber = 0
    activeBook = book

    refreshTitle()
    refreshDetails()
    refreshPage()
  }

  private def refreshUsername(): Unit = {
    // updates username display
  }

  private def refreshTitle(): Unit = {
    // updates title display
  }

  private def refreshDetails(): Unit = {
    // updates details display
  }

  private def refreshPage(): Unit = {
    // updated page display
  }

  def turnPageForward(): Unit = {
    pageNumber += 1
    refreshPage()
  }

  def turnPageBackward(): Unit = {
    pageNumber -= 1
    refreshPage()
  }
}
