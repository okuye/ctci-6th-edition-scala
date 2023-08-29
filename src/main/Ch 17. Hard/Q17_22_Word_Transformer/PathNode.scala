package Q17_22_Word_Transformer

class PathNode(word: String, previous: PathNode) {
  def getWord: String = word

  def collapse(startsWithRoot: Boolean): List[String] = {
    var path: List[String] = List()
    var node: PathNode = this
    while (node != null) {
      if (startsWithRoot) {
        path = node.word :: path
      } else {
        path = path :+ node.word
      }
      node = node.previousNode
    }
    path
  }
}

