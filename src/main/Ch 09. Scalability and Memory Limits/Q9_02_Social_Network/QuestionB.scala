package Q9_02_Social_Network

import scala.collection.mutable

object QuestionB {

  def mergePaths(
      bfs1: BFSData,
      bfs2: BFSData,
      connection: Int
  ): mutable.ListBuffer[Person] = {
    val end1 = bfs1.visited(connection)
    val end2 = bfs2.visited(connection)
    val pathOne =
      mutable.ListBuffer[Person]() ++= end1.collapse(startsWithRoot = false)
    val pathTwo =
      mutable.ListBuffer[Person]() ++= end2.collapse(startsWithRoot = true)
    pathTwo.remove(0)
    pathOne ++= pathTwo
    pathOne
  }

  def searchLevel(
      people: mutable.HashMap[Int, Person],
      primary: BFSData,
      secondary: BFSData
  ): Option[Person] = {
    val count = primary.toVisit.size
    for (_ <- 0 until count) {
      val pathNode = primary.toVisit.dequeue()
      val personId = pathNode.getPerson.getID

      if (secondary.visited.contains(personId)) {
        return Some(pathNode.getPerson)
      }

      val person = pathNode.getPerson
      val friends = person.getFriends
      for (friendId <- friends) {
        if (!primary.visited.contains(friendId)) {
          val friend = people(friendId)
          val next = new PathNode(friend, pathNode)

          primary.visited(friendId) = next
          primary.toVisit.enqueue(next)
        }
      }
    }
    None
  }

  def findPathBiBFS(
      people: mutable.HashMap[Int, Person],
      source: Int,
      destination: Int
  ): mutable.ListBuffer[Person] = {
    val sourceData = new BFSData(people(source))
    val destData = new BFSData(people(destination))

    while (!sourceData.isFinished && !destData.isFinished) {
      searchLevel(people, sourceData, destData) match {
        case Some(collision) =>
          return mergePaths(sourceData, destData, collision.getID)
        case None =>
      }

      searchLevel(people, destData, sourceData) match {
        case Some(collision) =>
          return mergePaths(sourceData, destData, collision.getID)
        case None =>
      }
    }
    mutable.ListBuffer[Person]()
  }

  def main(args: Array[String]): Unit = {
    val nPeople = 11
    val people = mutable.HashMap[Int, Person]()
    for (i <- 0 until nPeople) {
      val p = new Person(i)
      people(i) = p
    }

    val edges = Array(
      Array(1, 4),
      Array(1, 2),
      Array(1, 3),
      Array(3, 2),
      Array(4, 6),
      Array(3, 7),
      Array(6, 9),
      Array(9, 10),
      Array(5, 10),
      Array(2, 5),
      Array(3, 7)
    )

    for (edge <- edges) {
      val source = people(edge(0))
      source.addFriend(edge(1))

      val destination = people(edge(1))
      destination.addFriend(edge(0))
    }

    val i = 1
    val j = 10
    val path1 = findPathBiBFS(people, i, j)
    Tester.printPeople(Some(path1.toList))
  }
}
