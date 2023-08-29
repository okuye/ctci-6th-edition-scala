package Q16_22_Langtons_Ant

class Ant {
  var position: Position = new Position(0, 0)
  var orientation: Orientation.Value = Orientation.right

  def turn(clockwise: Boolean): Unit = {
    orientation = Orientation.getTurn(orientation, clockwise)
  }

  def move(): Unit = {
    orientation match {
      case Orientation.left => position.column -= 1
      case Orientation.right => position.column += 1
      case Orientation.up => position.row -= 1
      case Orientation.down => position.row += 1
    }
  }

  def adjustPosition(shiftRow: Int, shiftColumn: Int): Unit = {
    position.row += shiftRow
    position.column += shiftColumn
  }
}

object Orientation extends Enumeration {
  val up, down, left, right = Value

  def getTurn(current: Value, clockwise: Boolean): Value = {
    if (clockwise) {
      current match {
        case up => right
        case right => down
        case down => left
        case left => up
      }
    } else {
      current match {
        case up => left
        case left => down
        case down => right
        case right => up
      }
    }
  }
}

class Position(var row: Int, var column: Int)
