package CtCILibrary

class TreeNode(var data: Int) {
  var left: TreeNode = _
  var right: TreeNode = _
  var parent: TreeNode = _
  var _size = 1

  private def setLeftChild(left: TreeNode): Unit = {
    this.left = left
    if (left != null) {
      left.parent = this
    }
  }

  private def setRightChild(right: TreeNode): Unit = {
    this.right = right
    if (right != null) {
      right.parent = this
    }
  }

  def insertInOrder(d: Int): Unit = {
    if (d <= data) {
      if (left == null) {
        setLeftChild(new TreeNode(d))
      } else {
        left.insertInOrder(d)
      }
    } else {
      if (right == null) {
        setRightChild(new TreeNode(d))
      } else {
        right.insertInOrder(d)
      }
    }
    _size += 1
  }

  def size(): Int = _size

  def isBST: Boolean = {
    if (left != null && (data < left.data || !left.isBST)) {
      false
    } else if (right != null && (data >= right.data || !right.isBST)) {
      false
    } else {
      true
    }
  }

  def height: Int = {
    val leftHeight = if (left != null) left.height else 0
    val rightHeight = if (right != null) right.height else 0
    1 + Math.max(leftHeight, rightHeight)
  }

  def find(d: Int): TreeNode = {
    if (d == data) {
      this
    } else if (d <= data) {
      if (left != null) left.find(d) else null
    } else {
      if (right != null) right.find(d) else null
    }
  }

  def print(): Unit = BTreePrinter.printNode(this)
}

object TreeNode {
  private def createMinimalBST(arr: Array[Int], start: Int, end: Int): TreeNode = {
    if (end < start) {
      null
    } else {
      val mid = (start + end) / 2
      val n = new TreeNode(arr(mid))
      n.setLeftChild(createMinimalBST(arr, start, mid - 1))
      n.setRightChild(createMinimalBST(arr, mid + 1, end))
      n
    }
  }

  def createMinimalBST(array: Array[Int]): TreeNode = {
    createMinimalBST(array, 0, array.length - 1)
  }
}
