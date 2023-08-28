package Q4_07_Build_Order.EdgeRemoval

import scala.collection.mutable.ArrayBuffer

object Question {

  def buildGraph(projects: Array[String], dependencies: Array[Array[String]]): Graph = {
    val graph = new Graph()
    projects.foreach(graph.getOrCreateNode)

    dependencies.foreach(dependency => {
      val first = dependency(0)
      val second = dependency(1)
      graph.addEdge(first, second)
    })

    graph
  }

  def addNonDependent(order: Array[Project], projects: ArrayBuffer[Project], offset: Int): Int = {
    var newOffset = offset
    projects.foreach(project => {
      if (project.getNumberDependencies == 0) {
        order(newOffset) = project
        newOffset += 1
      }
    })
    newOffset
  }

  def orderProjects(projects: ArrayBuffer[Project]): Array[Project] = {
    val order = new Array[Project](projects.size)

    var endOfList = addNonDependent(order, projects, 0)

    var toBeProcessed = 0
    while (toBeProcessed < order.length) {
      val current = order(toBeProcessed)

      if (current == null) {
        return null
      }

      val children = current.getChildren
      children.foreach(_.decrementDependencies())

      endOfList = addNonDependent(order, children, endOfList)

      toBeProcessed += 1
    }

    order
  }

  def convertToStringList(projects: Array[Project]): Array[String] = {
    projects.map(_.getName)
  }

  def findBuildOrder(projects: Array[String], dependencies: Array[Array[String]]): Array[Project] = {
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
