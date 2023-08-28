package Q4_06_Successor

import CtCILibrary.TreeNode

object Question {

  def inorderSucc(n: TreeNode): TreeNode = {
    if (n == null) return null

    // Found right children -> return leftmost node of right subtree
    if (n.parent == null || n.right != null) {
      leftMostChild(n.right)
    } else {
      var q = n
      var x = q.parent
      // Go up until we're on left instead of right
      while (x != null && x.left != q) {
        q = x
        x = x.parent
      }
      x
    }
  }

  def leftMostChild(n: TreeNode): TreeNode = {
    var current = n
    if (current == null) {
      return null
    }
    while (current.left != null) {
      current = current.left
    }
    current
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array)
    for (i <- array.indices) {
      val node = root.find(array(i))
      val next = inorderSucc(node)
      if (next != null) {
        println(s"${node.data} -> ${next.data}")
      } else {
        println(s"${node.data} -> null")
      }
    }
  }
}
