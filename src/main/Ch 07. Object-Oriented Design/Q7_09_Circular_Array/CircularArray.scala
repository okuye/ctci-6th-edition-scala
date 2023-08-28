package Q7_09_Circular_Array

class CircularArray[T](size: Int) extends Iterable[T] {
  private val items: Array[AnyRef] = new Array[AnyRef](size)
  private var head = 0

  private def convert(index: Int): Int = {
    var adjustedIndex = index
    if (index < 0) {
      adjustedIndex += items.length
    }
    (head + adjustedIndex) % items.length
  }

  def rotate(shiftRight: Int): Unit = {
    head = convert(shiftRight)
  }

  def get(i: Int): T = {
    if (i < 0 || i >= items.length) {
      throw new IndexOutOfBoundsException(s"Index $i is out of bounds")
    }
    items(convert(i)).asInstanceOf[T]
  }

  def set(i: Int, item: T): Unit = {
    items(convert(i)) = item.asInstanceOf[AnyRef]
  }

  def iterator: Iterator[T] = new CircularArrayIterator

  private class CircularArrayIterator extends Iterator[T] {
    private var _current = -1

    override def hasNext: Boolean = _current < items.length - 1

    override def next(): T = {
      _current += 1
      items(convert(_current)).asInstanceOf[T]
    }
  }
}
