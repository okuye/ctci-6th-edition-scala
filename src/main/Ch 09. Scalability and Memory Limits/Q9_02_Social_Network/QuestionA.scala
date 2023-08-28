package Q9_02_Social_Network

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object QuestionA {
  def findPathBFS(
      people: mutable.HashMap[Int, Person],
      source: Int,
      destination: Int
  ): List[Person] = {
    val toVisit = mutable.Queue[PathNode]()
    val visited = mutable.HashSet[Int]()

    toVisit.enqueue(new PathNode(people(source), null))
    visited += source

    while (toVisit.nonEmpty) {
      val node = toVisit.dequeue()
      val person = node.getPerson
      if (person.getID == destination) {
        return node.collapse(false) // Removed 'toStart = '
      }

      // Search friends.
      val friends = person.getFriends
      for (friendId <- friends) {
        if (!visited.contains(friendId)) {
          visited += friendId
          val friend = people(friendId)
          toVisit.enqueue(new PathNode(friend, node))
        }
      }
    }

    List()
  }

  def main(args: Array[String]): Unit = {
    val nPeople = 11
    val people = mutable.HashMap[Int, Person]()
    for (i <- 0 until nPeople) {
      val p = new Person(i)
      people(i) = p
    }

    val edges = Array(
      (1, 4),
      (1, 2),
      (1, 3),
      (3, 2),
      (4, 6),
      (3, 7),
      (6, 9),
      (9, 10),
      (5, 10),
      (2, 5),
      (3, 7)
    )

    for (edge <- edges) {
      val source = people(edge._1)
      source.addFriend(edge._2)

      val destination = people(edge._2)
      destination.addFriend(edge._1)
    }

    val i = 1
    val j = 10
    val path1 = findPathBFS(people, i, j)
    Tester.printPeople(Some(path1)) // Wrap path1 in Some()
  }
}
