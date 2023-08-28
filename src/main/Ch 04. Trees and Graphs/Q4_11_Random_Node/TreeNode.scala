package Q4_11_Random_Node

import scala.util.Random

class TreeNode(var data: Int) {
  var left: TreeNode = _
  var right: TreeNode = _
  private var _size: Int = 1

  def insertInOrder(d: Int): Unit = {
    if (d <= data) {
      if (left == null) {
        left = new TreeNode(d)
      } else {
        left.insertInOrder(d)
      }
    } else {
      if (right == null) {
        right = new TreeNode(d)
      } else {
        right.insertInOrder(d)
      }
    }
    _size += 1
  }

  def size(): Int = _size

  def find(d: Int): TreeNode = {
    if (d == data) {
      this
    } else if (d <= data) {
      if (left != null) left.find(d) else null
    } else {
      if (right != null) right.find(d) else null
    }
  }

  def getRandomNode(): TreeNode = {
    val leftSize = if (left == null) 0 else left.size
    val index = Random.nextInt(size)
    if (index < leftSize) {
      left.getRandomNode()
    } else if (index == leftSize) {
      this
    } else {
      right.getRandomNode()
    }
  }

  def getIthNode(i: Int): TreeNode = {
    val leftSize = if (left == null) 0 else left.size
    if (i < leftSize) {
      left.getIthNode(i)
    } else if (i == leftSize) {
      this
    } else {
      right.getIthNode(i - (leftSize + 1))
    }
  }
}
