package Introduction

import CtCILibrary.TreeNode

object Traversals {
  def visit(node: TreeNode): Unit = {
    if (node != null) {
      println(node.data)
    }
  }

  def inOrderTraversal(node: TreeNode): Unit = {
    if (node != null) {
      inOrderTraversal(node.left)
      visit(node)
      inOrderTraversal(node.right)
    }
  }

  def preOrderTraversal(node: TreeNode): Unit = {
    if (node != null) {
      visit(node)
      inOrderTraversal(node.left)
      inOrderTraversal(node.right)
    }
  }

  def postOrderTraversal(node: TreeNode): Unit = {
    if (node != null) {
      inOrderTraversal(node.left)
      inOrderTraversal(node.right)
      visit(node)
    }
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // We needed this code for other files, so check out the code in the library
    val root = TreeNode.createMinimalBST(array)
    inOrderTraversal(root)
  }
}
