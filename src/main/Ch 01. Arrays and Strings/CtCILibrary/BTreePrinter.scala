package CtCILibrary

object BTreePrinter {

  def printNode(root: TreeNode): Unit = {
    val maximumLevel = maxLevel(root)
    printNodeInternal(List(root), 1, maximumLevel)
  }

  private def printNodeInternal(
      nodes: List[TreeNode],
      level: Int,
      maxLevel: Int
  ): Unit = {
    if (nodes.isEmpty || nodes.forall(_ == null)) return

    val floor = maxLevel - level
    val edgeLines = math.pow(2, floor.max(0)).toInt
    val firstSpaces = (math.pow(2, floor) - 1).toInt
    val betweenSpaces = (math.pow(2, floor + 1) - 1).toInt
    printWhitespaces(firstSpaces)

    val newNodes = nodes.flatMap { node =>
      if (node != null) {
        print(node.data)
        List(node.left, node.right)
      } else {
        print(" ")
        List[TreeNode](null, null)
      }
    }

    println()

    for (i <- 1 to edgeLines) {
      for (node <- nodes) {
        printWhitespaces(firstSpaces - i)
        if (node == null) {
          printWhitespaces(edgeLines + edgeLines + i + 1)
        } else {
          if (node.left != null) print("/") else printWhitespaces(1)
          printWhitespaces(i + i - 1)
          if (node.right != null) print("\\") else printWhitespaces(1)
          printWhitespaces(edgeLines + edgeLines - i)
        }
      }
      println()
    }

    printNodeInternal(newNodes, level + 1, maxLevel)
  }

  private def printWhitespaces(count: Int): Unit = {
    for (_ <- 0 until count) print(" ")
  }

  private def maxLevel(node: TreeNode): Int = {
    if (node == null) return 0
    math.max(maxLevel(node.left), maxLevel(node.right)) + 1
  }

  private def isAllElementsNull[T](list: List[T]): Boolean = {
    list.forall(_ == null)
  }
}
