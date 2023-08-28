package Q4_08_First_Common_Ancestor
import CtCILibrary.TreeNode;
//class TreeNode(
//    val data: Int,
//    var left: TreeNode = null,
//    var right: TreeNode = null
//) {
//  def find(d: Int): TreeNode = {
//    if (d == data) {
//      this
//    } else if (d <= data) {
//      left.find(d)
//    } else if (d > data) {
//      right.find(d)
//    } else {
//      null
//    }
//  }
//
//  // Additional methods to create a minimal BST and other utilities can be added here
//}

object Question {
  val TWO_NODES_FOUND = 2
  val ONE_NODE_FOUND = 1
  val NO_NODES_FOUND = 0

  def covers(root: TreeNode, p: TreeNode, q: TreeNode): Int = {
    var ret = NO_NODES_FOUND
    if (root == null) return ret
    if (root == p || root == q) ret += 1
    ret += covers(root.left, p, q)
    if (ret == TWO_NODES_FOUND) return ret
    ret + covers(root.right, p, q)
  }

  def commonAncestor(root: TreeNode, p: TreeNode, q: TreeNode): TreeNode = {
    if (q == p && (root.left == q || root.right == q)) return root
    val nodesFromLeft = covers(root.left, p, q)
    if (nodesFromLeft == TWO_NODES_FOUND) {
      if (root.left == p || root.left == q) return root.left
      else return commonAncestor(root.left, p, q)
    } else if (nodesFromLeft == ONE_NODE_FOUND) {
      if (root == p) return p
      else if (root == q) return q
    }

    val nodesFromRight = covers(root.right, p, q)
    if (nodesFromRight == TWO_NODES_FOUND) {
      if (root.right == p || root.right == q) return root.right
      else return commonAncestor(root.right, p, q)
    } else if (nodesFromRight == ONE_NODE_FOUND) {
      if (root == p) return p
      else if (root == q) return q
    }

    if (nodesFromLeft == ONE_NODE_FOUND && nodesFromRight == ONE_NODE_FOUND)
      root
    else null
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val root =
      TreeNode.createMinimalBST(array) // You'll need to implement this method
    val n3 = root.find(1)
    val n7 = root.find(7)
    val ancestor = commonAncestor(root, n3, n7)
    println(ancestor.data)
  }
}
