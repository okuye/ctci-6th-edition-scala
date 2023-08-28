package Q4_11_Random_Node

object Question extends App {

  val counts = Array.fill(10)(0)

  for (_ <- 1 to 1000000) {
    val tree = new Tree()
    val array = Array(1, 0, 6, 2, 3, 9, 4, 5, 8, 7)
    array.foreach(x => tree.insertInOrder(x))
    val d = tree.getRandomNode().data
    counts(d) += 1
  }

  for (i <- counts.indices) {
    println(s"$i: ${counts(i)}")
  }

}
