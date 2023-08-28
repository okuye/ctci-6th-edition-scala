package Q9_02_Social_Network

import scala.collection.mutable

class BFSData(root: Person) {
  val toVisit: mutable.Queue[PathNode] = mutable.Queue(new PathNode(root, null))
  val visited: mutable.HashMap[Int, PathNode] =
    mutable.HashMap(root.getID -> toVisit.head)

  def isFinished(): Boolean = toVisit.isEmpty
}
