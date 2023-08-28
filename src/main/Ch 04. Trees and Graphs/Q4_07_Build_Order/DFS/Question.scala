package Q4_07_Build_Order.DFS


//package Q4_07_Build_Order.DFS
import scala.collection.mutable.Stack

object Question {

  def buildGraph(projects: Array[String], dependencies: Array[Array[String]]): Graph = {
    val graph = new Graph()

    for (dependency <- dependencies) {
      val first = dependency(0)
      val second = dependency(1)
      graph.addEdge(first, second)
    }

    graph
  }

  def doDFS(project: Project, stack: Stack[Project]): Boolean = {
    if (project.getState == State.PARTIAL) {
      return false // Cycle
    }

    if (project.getState == State.BLANK) {
      project.setState(State.PARTIAL)
      val children = project.getChildren
      for (child <- children) {
        if (!doDFS(child, stack)) {
          return false
        }
      }
      project.setState(State.COMPLETE)
      stack.push(project)
    }
    true
  }

  def orderProjects(projects: Seq[Project]): Stack[Project] = {
    val stack = Stack[Project]()
    for (project <- projects) {
      if (project.getState == State.BLANK) {
        if (!doDFS(project, stack)) {
          return null
        }
      }
    }
    stack
  }

  def convertToStringList(projects: Stack[Project]): Array[String] = {
    projects.map(_.getName).toArray.reverse
  }

  def findBuildOrder(projects: Array[String], dependencies: Array[Array[String]]): Stack[Project] = {
    val graph = buildGraph(projects, dependencies)
    orderProjects(graph.getNodes)
  }

  def buildOrderWrapper(projects: Array[String], dependencies: Array[Array[String]]): Array[String] = {
    val buildOrder = findBuildOrder(projects, dependencies)
    if (buildOrder == null) null else convertToStringList(buildOrder)
  }

  def main(args: Array[String]): Unit = {
    val projects = Array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j")
    val dependencies = Array(
      Array("a", "b"),
      Array("b", "c"),
      Array("a", "c"),
      Array("d", "e"),
      Array("b", "d"),
      Array("e", "f"),
      Array("a", "f"),
      Array("h", "i"),
      Array("h", "j"),
      Array("i", "j"),
      Array("g", "j")
    )
    val buildOrder = buildOrderWrapper(projects, dependencies)
    if (buildOrder == null) {
      println("Circular Dependency.")
    } else {
      buildOrder.foreach(println)
    }
  }
}
