package Q9_05_Cache

class Node(var query: String, var results: Array[String]) {
  var prev: Node = _
  var next: Node = _
}
