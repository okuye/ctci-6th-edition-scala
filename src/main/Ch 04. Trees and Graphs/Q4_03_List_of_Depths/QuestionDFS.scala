package Q4_03_List_of_Depths

import CtCILibrary.{AssortedMethods, TreeNode}

object QuestionDFS extends App {

  def createLevelLinkedList(
      root: TreeNode,
      lists: List[List[TreeNode]],
      level: Int
  ): List[List[TreeNode]] = {
    if (root == null) return lists

    if (lists.size == level) {
      val newList = root :: Nil
      val updatedLists = lists :+ newList
      val leftLists = createLevelLinkedList(root.left, updatedLists, level + 1)
      createLevelLinkedList(root.right, leftLists, level + 1)
    } else {
      val updatedList = root :: lists(level)
      val updatedLists = lists.updated(level, updatedList)
      val leftLists = createLevelLinkedList(root.left, updatedLists, level + 1)
      createLevelLinkedList(root.right, leftLists, level + 1)
    }
  }

  def createLevelLinkedList(root: TreeNode): List[List[TreeNode]] = {
    createLevelLinkedList(root, List.empty[List[TreeNode]], 0)
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
