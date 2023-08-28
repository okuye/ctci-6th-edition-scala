package Q8_02_Robot_in_a_Grid

import scala.collection.mutable.ArrayBuffer
import CtCILibrary.AssortedMethods

object QuestionA {

  def getPath(maze: Array[Array[Boolean]]): Option[ArrayBuffer[Point]] = {
    if (maze == null || maze.isEmpty) return None
    val path = ArrayBuffer[Point]()
    if (getPath(maze, maze.length - 1, maze(0).length - 1, path)) {
      Some(path)
    } else {
      None
    }
  }

  def getPath(maze: Array[Array[Boolean]], row: Int, col: Int, path: ArrayBuffer[Point]): Boolean = {
    if (col < 0 || row < 0 || !maze(row)(col)) {
      return false
    }

    val isAtOrigin = (row == 0) && (col == 0)

    if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
      path += Point(row, col)
      true
    } else {
      false
    }
  }

  def main(args: Array[String]): Unit = {
    val size = 5
    val maze = AssortedMethods.randomBooleanMatrix(size, size, 70)

    AssortedMethods.printMatrix(maze)

    getPath(maze) match {
      case Some(path) => println(path.mkString(", "))
      case None => println("No path found.")
    }
  }
}
