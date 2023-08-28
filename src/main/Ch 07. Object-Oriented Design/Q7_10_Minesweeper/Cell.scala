package Q7_10_Minesweeper

class Cell(r: Int, c: Int) {
  private var row: Int = r
  private var column: Int = c
  private var _isBomb: Boolean = false
  private var number: Int = 0
  private var _isExposed: Boolean = false
  private var _isGuess: Boolean = false

  def setRowAndColumn(r: Int, c: Int): Unit = {
    row = r
    column = c
  }

  def setBomb(bomb: Boolean): Unit = {
    _isBomb = bomb
    number = if (bomb) -1 else number
  }

  def incrementNumber(): Unit = {
    number += 1
  }

  def getRow: Int = row

  def getColumn: Int = column

  def isBomb: Boolean = _isBomb

  def isBlank: Boolean = number == 0

  def isExposed: Boolean = _isExposed

  def flip(): Boolean = {
    _isExposed = true
    !_isBomb
  }

  def toggleGuess(): Boolean = {
    if (!_isExposed) {
      _isGuess = !_isGuess
    }
    _isGuess
  }

  def isGuess: Boolean = _isGuess

  override def toString: String = getUndersideState

  def getSurfaceState: String = {
    if (_isExposed) {
      getUndersideState
    } else if (_isGuess) {
      "B "
    } else {
      "? "
    }
  }

  def getUndersideState: String = {
    if (_isBomb) {
      "* "
    } else if (number > 0) {
      s"$number "
    } else {
      "  "
    }
  }
}
