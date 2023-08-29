package Q17_08_Circus_Tower

case class HtWt(height: Int, weight: Int) extends Ordered[HtWt] {

  override def compare(that: HtWt): Int = {
    if (this.height != that.height) {
      this.height.compare(that.height)
    } else {
      this.weight.compare(that.weight)
    }
  }

  override def toString: String = s"($height, $weight)"

  def isBefore(other: HtWt): Boolean = {
    height < other.height && weight < other.weight
  }
}
