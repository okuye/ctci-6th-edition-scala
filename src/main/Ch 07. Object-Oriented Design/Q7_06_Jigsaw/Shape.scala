package Q7_06_Jigsaw

object Shape extends Enumeration {
  type Shape = Value
  val INNER, OUTER, FLAT = Value

  def getOpposite(shape: Shape): Option[Shape] = shape match {
    case INNER => Some(OUTER)
    case OUTER => Some(INNER)
    case _ => None
  }
}