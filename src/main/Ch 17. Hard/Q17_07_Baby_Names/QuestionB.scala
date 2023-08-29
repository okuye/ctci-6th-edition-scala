package Q17_07_Baby_Names

import scala.collection.mutable

object QuestionB {

  def constructGraph(names: Map[String, Int]): Graph = {
    val graph = new Graph()
    for ((name, frequency) <- names) {
      graph.createNode(name, frequency)
    }
    graph
  }

  def connectEdges(graph: Graph, synonyms: Array[Array[String]]): Unit = {
    for (entry <- synonyms) {
      val name1 = entry(0)
      val name2 = entry(1)
      graph.addEdge(name1, name2)
    }
  }

  def getComponentFrequency(node: GraphNode): Int = {
    if (node.isVisited) {
      0
    } else {
      node.setIsVisited(true)
      val sum = node.getFrequency
      sum + node.getNeighbors.map(getComponentFrequency).sum
    }
  }

  def getTrueFrequencies(graph: Graph): Map[String, Int] = {
    val rootNames = mutable.Map[String, Int]()
    for (node <- graph.getNodes if !node.isVisited) {
      val frequency = getComponentFrequency(node)
      val name = node.name
      rootNames(name) = frequency
    }
    rootNames.toMap
  }

  def trulyMostPopular(
      names: Map[String, Int],
      synonyms: Array[Array[String]]
  ): Map[String, Int] = {
    val graph = constructGraph(names)
    connectEdges(graph, synonyms)
    getTrueFrequencies(graph)
  }

  def main(args: Array[String]): Unit = {
    val names = Map(
      "John" -> 3,
      "Jonathan" -> 4,
      "Johnny" -> 5,
      "Chris" -> 1,
      "Kris" -> 3,
      "Brian" -> 2,
      "Bryan" -> 4,
      "Carleton" -> 4
    )

    val synonyms = Array(
      Array("John", "Jonathan"),
      Array("Jonathan", "Johnny"),
      Array("Chris", "Kris"),
      Array("Brian", "Bryan")
    )

    val rootNames = trulyMostPopular(names, synonyms)
    for ((name, frequency) <- rootNames) {
      println(s"$name: $frequency")
    }
  }

}
