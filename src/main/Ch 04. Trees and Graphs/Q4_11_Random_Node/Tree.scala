package Q4_11_Random_Node

import scala.util.Random

class Tree {
  var root: TreeNode = _

  def insertInOrder(value: Int): Unit = {
    if (root == null) {
      root = new TreeNode(value)
    } else {
      root.insertInOrder(value)
    }
  }

  def size(): Int = {
    if (root == null) 0 else root.size()
  }

  def getRandomNode(): TreeNode = {
    if (root == null) return null

    val i = Random.nextInt(size())
    root.getIthNode(i)
  }
}
