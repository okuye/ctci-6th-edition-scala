package Q16_22_Langtons_Ant

object Orientation extends Enumeration {
  type Orientation = Value

  val Left, Up, Right, Down = Value

  def getTurn(orientation: Orientation, clockwise: Boolean): Orientation = {
    orientation match {
      case Left  => if (clockwise) Up else Down
      case Up    => if (clockwise) Right else Left
      case Right => if (clockwise) Down else Up
      case Down  => if (clockwise) Left else Right
    }
  }

   def toString(orientation: Orientation): String = {
    orientation match {
      case Left  => "\u2190"
      case Up    => "\u2191"
      case Right => "\u2192"
      case Down  => "\u2193"
    }
  }
}
