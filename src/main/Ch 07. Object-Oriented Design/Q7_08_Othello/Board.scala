package Q7_08_Othello
import Q7_08_Othello.Piece

class Board(rows: Int, columns: Int) {
  private var blackCount = 0
  private var whiteCount = 0
  private val board: Array[Array[Option[Piece]]] = Array.fill(rows, columns)(None)

  def initialize(): Unit = {
    val middleRow = board.length / 2
    val middleColumn = board(middleRow).length / 2
    board(middleRow)(middleColumn) = Some(new Piece(Color.White))
    board(middleRow + 1)(middleColumn) = Some(new Piece(Color.Black))
    board(middleRow + 1)(middleColumn + 1) = Some(new Piece(Color.White))
    board(middleRow)(middleColumn + 1) = Some(new Piece(Color.Black))
    blackCount = 2
    whiteCount = 2
  }

  def placeColor(row: Int, column: Int, color: Color.Value): Boolean = {
    if (board(row)(column).isDefined) return false

    val results = Array(
      flipSection(row - 1, column, color, Direction.Up),
      flipSection(row + 1, column, color, Direction.Down),
      flipSection(row, column + 1, color, Direction.Right),
      flipSection(row, column - 1, color, Direction.Left)
    )

    val flipped = results.filter(_ > 0).sum

    if (flipped <= 0) return false

    board(row)(column) = Some(new Piece(color))
    updateScore(color, flipped + 1)
    true
  }

  private def flipSection(row: Int, column: Int, color: Color.Value, d: Direction.Value): Int = {
    val (r, c) = d match {
      case Direction.Up => (-1, 0)
      case Direction.Down => (1, 0)
      case Direction.Left => (0, -1)
      case Direction.Right => (0, 1)
    }

    if (row < 0 || row >= board.length || column < 0 || column >= board(row).length || board(row)(column).isEmpty) {
      return -1
    }

    if (board(row)(column).get.getColor == color)
    {
      return 0
    }

    val flipped = flipSection(row + r, column + c, color, d)
    if (flipped < 0) {
      return -1
    }

    board(row)(column) = Some(board(row)(column).get.flip())
    flipped + 1
  }

  def getScoreForColor(c: Color.Value): Int = {
    if (c == Color.Black) blackCount else whiteCount
  }

  def updateScore(newColor: Color.Value, newPieces: Int): Unit = {
    if (newColor == Color.Black) {
      whiteCount -= newPieces - 1
      blackCount += newPieces
    } else {
      blackCount -= newPieces - 1
      whiteCount += newPieces
    }
  }

  def printBoard(): Unit = {
    for (r <- board.indices) {
      for (c <- board(r).indices) {
        print(board(r)(c) match {
          case None => "_"
          case Some(piece) if piece.getColor == Color.White => "W"
          case _ => "B"
        })
      }
      println()
    }
  }
}
