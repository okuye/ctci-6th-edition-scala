package Q16_22_Langtons_Ant

object Question extends App {

  val board = new Board()
  val grid = new Grid()

  println(board.toString)
  for (i <- 0 until 100) {
    println(s"\n\n---- MOVE $i ----")
    board.move()
    val bs = board.toString
    println(bs)

    grid.move()
    val gs = grid.toString
    println(gs)

    val equals = bs == gs
    println(equals)

    if (!equals) {
      sys.exit() // Exit the loop and program
    }
  }
}
