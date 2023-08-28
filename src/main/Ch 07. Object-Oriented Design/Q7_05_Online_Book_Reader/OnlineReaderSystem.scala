package Q7_05_Online_Book_Reader

class OnlineReaderSystem {
  private val library: Library = new Library()
  private val userManager: UserManager = new UserManager()
  private val display: Display = new Display()

  private var activeBook: Option[Book] = None
  private var activeUser: Option[User] = None

  def getLibrary: Library = library

  def getUserManager: UserManager = userManager

  def getDisplay: Display = display

  def getActiveBook: Option[Book] = activeBook

  def setActiveBook(book: Book): Unit = {
    display.displayBook(book)
    activeBook = Some(book)
  }

  def getActiveUser: Option[User] = activeUser

  def setActiveUser(user: User): Unit = {
    activeUser = Some(user)
    display.displayUser(user)
  }
}
