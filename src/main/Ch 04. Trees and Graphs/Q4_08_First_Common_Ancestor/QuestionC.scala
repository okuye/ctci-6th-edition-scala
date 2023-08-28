package Q4_08_First_Common_Ancestor

import CtCILibrary.TreeNode


object QuestionC {

  def commonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (!covers(root, p) || !covers(root, q)) {
      null
    } else if (covers(p, q)) {
      p
    } else if (covers(q, p)) {
      q
    } else {
      var sibling = getSibling(p)
      var parent = p.parent
      while (!covers(sibling, q)) {
        sibling = getSibling(parent)
        parent = parent.parent
      }
      parent
    }
  }

  def covers(root: TreeNode, p: TreeNode): Boolean = {
    if (root == null) return false
    if (root == p) return true
    covers(root.left, p) || covers(root.right, p)
  }

  def getSibling(node: TreeNode): TreeNode = {
    if (node == null || node.parent == null) {
      null
    } else {
      val parent = node.parent
      if (parent.left == node) parent.right else parent.left
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root = TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(1)
    val n7 = root.find(7)
    val ancestor = commonAncestor(root, n3, n7)
    println(ancestor.data)
  }
}
