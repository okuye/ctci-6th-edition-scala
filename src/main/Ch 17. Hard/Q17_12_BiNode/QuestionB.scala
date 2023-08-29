package Q17_12_BiNode


object QuestionB {

  var count: Int = 0

  def convert(root: BiNode): BiNode = {
    if (root == null) return null

    val part1 = convert(root.node1)
    val part2 = convert(root.node2)

    if (part1 != null) concat(getTail(part1), root)
    if (part2 != null) concat(root, part2)

    if (part1 == null) root else part1
  }

  def getTail(node: BiNode): BiNode = {
    var current = node
    while (current != null && current.node2 != null) {
      count += 1
      current = current.node2
    }
    current
  }

  def concat(x: BiNode, y: BiNode): Unit = {
    x.node2 = y
    y.node1 = x
  }

  def printLinkedListTree(root: BiNode): Unit = {
    var node = root
    while (node != null) {
      if (node.node2 != null && node.node2.node1 != node) {
        print(s"inconsistent node: $node")
      }
      print(s"${node.data}->")
      node = node.node2
    }
    println()
  }

  def createTree(): BiNode = {
    val nodes = Array.fill(7)(null: BiNode).zipWithIndex.map { case (_, i) => new BiNode(i) }
    nodes(4).node1 = nodes(2)
    nodes(4).node2 = nodes(5)
    nodes(2).node1 = nodes(1)
    nodes(2).node2 = nodes(3)
    nodes(5).node2 = nodes(6)
    nodes(1).node1 = nodes(0)
    nodes(4)
  }

  def printAsTree(root: BiNode, spaces: String): Unit = {
    if (root == null) {
      println(spaces + "- null")
    } else {
      println(spaces + "- " + root.data)
      printAsTree(root.node1, spaces + "   ")
      printAsTree(root.node2, spaces + "   ")
    }
  }

  def main(args: Array[String]): Unit = {
    val root = createTree()
    printAsTree(root, "")
    val n = convert(root)
    printLinkedListTree(n)
    println(count)
  }
}
