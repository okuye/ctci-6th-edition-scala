package Q4_03_List_of_Depths

import CtCILibrary.{AssortedMethods, TreeNode}

object QuestionBFS extends App {

  def createLevelLinkedList(root: TreeNode): List[List[TreeNode]] = {
    var result = List[List[TreeNode]]()
    var current = List[TreeNode]()

    if (root != null) {
      current = List(root)
    }

    while (current.nonEmpty) {
      result = result :+ current
      val parents = current
      current = List[TreeNode]()
      for (parent <- parents) {
        if (parent.left != null) {
          current = current :+ parent.left
        }
        if (parent.right != null) {
          current = current :+ parent.right
        }
      }
    }

    result
  }

  def printResult(result: List[List[TreeNode]]): Unit = {
    for ((entry, depth) <- result.zipWithIndex) {
      print(s"Link list at depth $depth:")
      for (node <- entry) {
        print(" " + node.data)
      }
      println()
    }
  }

  val nodesFlattened = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

  val root = AssortedMethods.createTreeFromArray(nodesFlattened)
  val list = createLevelLinkedList(root)
  printResult(list)
}
