package Q8_02_Robot_in_a_Grid

import CtCILibrary.AssortedMethods

object Tester extends App {
  val size = 5
  val maze = AssortedMethods.randomBooleanMatrix(size, size, 70)

  AssortedMethods.printMatrix(maze)

  val pathA = QuestionA.getPath(maze)
  val pathB = QuestionB.getPath(maze)

  pathA match {
    case Some(path) => println(path.mkString(", "))
    case None => println("No path found.")
  }

  pathB match {
    case Some(path) => println(path.mkString(", "))
    case None => println("No path found.")
  }
}
