package Q7_05_Online_Book_Reader

import scala.collection.mutable.HashMap

class Library {
  private val books: HashMap[Int, Book] = HashMap()

  def addBook(id: Int, details: String): Option[Book] = {
    if (books.contains(id)) {
      None
    } else {
      val book = new Book(id, details)
      books(id) = book
      Some(book)
    }
  }

  def remove(b: Book): Boolean = {
    remove(b.getID)
  }

  def remove(id: Int): Boolean = {
    if (!books.contains(id)) {
      false
    } else {
      books -= id
      true
    }
  }

  def find(id: Int): Option[Book] = {
    books.get(id)
  }
}
