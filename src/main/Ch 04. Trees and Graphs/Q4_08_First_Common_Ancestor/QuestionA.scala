package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode

object QuestionA {
  def commonAncestor(p: TreeNode, q: TreeNode): TreeNode = {
    if (p == q) return p

    var ancestor = p
    while (ancestor != null) {
      if (isOnPath(ancestor, q)) {
        return ancestor
      }
      ancestor = ancestor.parent
    }
    null
  }

  def isOnPath(ancestor: TreeNode, node: TreeNode): Boolean = {
    var n = node
    while (n != ancestor && n != null) {
      n = n.parent
    }
    n == ancestor
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(8)
    val n7 = root.find(8)
    val ancestor = commonAncestor(n3, n7)
    println(ancestor.data)
  }
}
