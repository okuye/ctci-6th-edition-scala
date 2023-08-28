package Q7_08_Othello

class Player(private var color: Color.Value) {

  def getScore: Int = Game.getInstance().getBoard.getScoreForColor(color)

  def playPiece(row: Int, column: Int): Boolean =
    Game.getInstance().getBoard.placeColor(row, column, color)

  def getColor: Color.Value = color
}
