package Q8_13_Stack_of_Boxes

class Box(val width: Int, val height: Int, val depth: Int) {
  def canBeUnder(b: Box): Boolean = {
    width > b.width && height > b.height && depth > b.depth
  }

  def canBeAbove(b: Box): Boolean = {
    if (b == null) {
      true
    } else {
      width < b.width && height < b.height && depth < b.depth
    }
  }

  override def toString: String = {
    s"Box($width,$height,$depth)"
  }
}