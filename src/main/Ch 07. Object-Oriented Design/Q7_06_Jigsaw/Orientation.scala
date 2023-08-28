package Q7_06_Jigsaw
object Orientation extends Enumeration {
  val LEFT, TOP, RIGHT, BOTTOM = Value

  def getOpposite(orientation: Orientation.Value): Option[Orientation.Value] = orientation match {
    case LEFT => Some(RIGHT)
    case RIGHT => Some(LEFT)
    case TOP => Some(BOTTOM)
    case BOTTOM => Some(TOP)
    case _ => None
  }
}

