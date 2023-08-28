package Q9_02_Social_Network

import scala.collection.mutable

object Tester {

  def printPeople(path: Option[List[Person]]): Unit = {
    path match {
      case None         => println("No path")
      case Some(people) => people.foreach(p => println(p.getID))
    }
  }

  def isEqual(
      path1: List[Person],
      path2: List[Person],
      reverse: Boolean
  ): Boolean = {
    if (path1.length != path2.length) return false

    path1.zipWithIndex.forall { case (person, idx) =>
      val otherIdx = if (reverse) path2.length - idx - 1 else idx
      person == path2(otherIdx)
    }
  }

  def isEquivalent(path1: List[Person], path2: List[Person]): Boolean = {
    isEqual(path1, path2, reverse = false) || isEqual(
      path1,
      path2,
      reverse = true
    )
  }

  def main(args: Array[String]): Unit = {
    val nPeople = 11
    val people = mutable.HashMap[Int, Person]()
    for (i <- 0 until nPeople) {
      val p = new Person(i)
      people.put(i, p)
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

    edges.foreach { edge =>
      val source = people(edge(0))
      source.addFriend(edge(1))
      val destination = people(edge(1))
      destination.addFriend(edge(0))
    }

    for (i <- 0 until nPeople; j <- 0 until nPeople) {
      val path1 = Option(QuestionA.findPathBFS(people, i, j).toList)
      val path2 = Option(QuestionB.findPathBiBFS(people, i, j).toList)
      if (
        !isEquivalent(
          path1.getOrElse(List.empty[Person]),
          path2.getOrElse(List.empty[Person])
        )
      ) {

        println(s"Not equal: $i to $j")
        println("Path 1")
        printPeople(path1)
        println("Path 2")
        printPeople(path2)
      } else {
        println(s"Is equal: $i to $j")
      }
    }
  }
}
