package Q16_04_Tic_Tac_Win

class PositionIterator(p: Position, rowIncrement: Int, colIncrement: Int, size: Int) extends Iterator[Position] {

  private var current = new Position(p.row - rowIncrement, p.column - colIncrement)

  override def hasNext: Boolean = {
    current.row + rowIncrement < size && current.column + colIncrement < size
  }

  override def next(): Position = {
    current = new Position(current.row + rowIncrement, current.column + colIncrement)
    current
  }
}
