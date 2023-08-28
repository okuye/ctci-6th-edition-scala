package Q7_08_Othello

class Piece(private var color: Color.Value) {

  def flip(): Piece = {
    color = if (color == Color.Black) Color.White else Color.Black
    this
  }

  def getColor: Color.Value = color
}
