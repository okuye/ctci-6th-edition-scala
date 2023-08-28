package Q7_08_Othello

class Location(private var row: Int, private var column: Int) {

  def isSameAs(r: Int, c: Int): Boolean = row == r && column == c

  def getRow: Int = row

  def getColumn: Int = column
}
