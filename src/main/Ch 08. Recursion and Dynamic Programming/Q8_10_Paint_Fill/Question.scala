object Question {

  object Color extends Enumeration {
    type Color = Value
    val Black, White, Red, Yellow, Green = Value
  }

  import Color._

  def printColor(c: Color): String = c match {
    case Black  => "B"
    case White  => "W"
    case Red    => "R"
    case Yellow => "Y"
    case Green  => "G"
    case _      => "X"
  }

  def printScreen(screen: Array[Array[Color]]): Unit = {
    for (row <- screen) {
      for (color <- row) {
        print(printColor(color))
      }
      println()
    }
  }

  def randomInt(n: Int): Int = scala.util.Random.nextInt(n)

  def paintFill(
      screen: Array[Array[Color]],
      r: Int,
      c: Int,
      ocolor: Color,
      ncolor: Color
  ): Boolean = {
    if (r < 0 || r >= screen.length || c < 0 || c >= screen(0).length) {
      return false
    }
    if (screen(r)(c) == ocolor) {
      screen(r)(c) = ncolor
      paintFill(screen, r - 1, c, ocolor, ncolor) // up
      paintFill(screen, r + 1, c, ocolor, ncolor) // down
      paintFill(screen, r, c - 1, ocolor, ncolor) // left
      paintFill(screen, r, c + 1, ocolor, ncolor) // right
    }
    true
  }

  def paintFill(
      screen: Array[Array[Color]],
      r: Int,
      c: Int,
      ncolor: Color
  ): Boolean = {
    if (screen(r)(c) == ncolor) return false
    paintFill(screen, r, c, screen(r)(c), ncolor)
  }

  def main(args: Array[String]): Unit = {
    val N = 10
    val screen = Array.fill(N, N)(Color.Black)
    for (_ <- 1 to 100) {
      screen(randomInt(N))(randomInt(N)) = Color.Green
    }
    printScreen(screen)
    paintFill(screen, 2, 2, Color.White)
    println()
    printScreen(screen)
  }
}
