package Q9_02_Social_Network

import scala.collection.mutable.ListBuffer

class PathNode(private val person: Person, private val previousNode: PathNode) {

  def getPerson: Person = person

  def collapse(startsWithRoot: Boolean): List[Person] = {
    val path = ListBuffer[Person]()
    var node: PathNode = this
    while (node != null) {
      if (startsWithRoot) {
        path += node.person
      } else {
        path.prepend(node.person)
      }
      node = node.previousNode
    }
    path.toList
  }
}
