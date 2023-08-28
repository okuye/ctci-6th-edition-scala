package Q4_07_Build_Order.DFS

import scala.collection.mutable

object State extends Enumeration {
  type State = Value
  val COMPLETE, PARTIAL, BLANK = Value
}

import scala.collection.mutable

class Project(n: String) {

  import State._

  private val children = mutable.ArrayBuffer[Project]()
  private val map = mutable.HashMap[String, Project]()
  private val name = n
  private var state: State = State.BLANK

  def getName: String = name

  def addNeighbor(node: Project): Unit = {
    if (!map.contains(node.getName)) {
      children += node
      map(node.getName) = node
    }
  }

  def getState: State = state

  def setState(st: State): Unit = {
    state = st
  }

  def getChildren: Seq[Project] = children.toSeq
}
