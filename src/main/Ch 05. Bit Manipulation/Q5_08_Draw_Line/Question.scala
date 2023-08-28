package Q5_08_Draw_Line

object Question {

  def computeByteNum(width: Int, x: Int, y: Int): Int = {
    (width * y + x) / 8
  }

  def drawLine(
      screen: Array[Byte],
      width: Int,
      x1: Int,
      x2: Int,
      y: Int
  ): Unit = {
    val start_offset = x1 % 8
    var first_full_byte = x1 / 8
    if (start_offset != 0) {
      first_full_byte += 1
    }

    val end_offset = x2 % 8
    var last_full_byte = x2 / 8
    if (end_offset != 7) {
      last_full_byte -= 1
    }

    // Set full bytes
    for (b <- first_full_byte to last_full_byte) {
      screen((width / 8) * y + b) = 0xff.toByte
    }

    val start_mask = (0xff >> start_offset).toByte
    val end_mask = (~(0xff >> (end_offset + 1))).toByte

    // Set start and end of line
    if ((x1 / 8) == (x2 / 8)) {
      val mask = (start_mask & end_mask).toByte
      screen((width / 8) * y + (x1 / 8)) =
        (screen((width / 8) * y + (x1 / 8)) | mask).toByte
    } else {
      if (start_offset != 0) {
        val byte_number = (width / 8) * y + first_full_byte - 1
        screen(byte_number) = (screen(byte_number) | start_mask).toByte
      }
      if (end_offset != 7) {
        val byte_number = (width / 8) * y + last_full_byte + 1
        screen(byte_number) = (screen(byte_number) | end_mask).toByte
      }
    }
  }

  def printByte(b: Byte): Unit = {
    for (i <- 7 to 0 by -1) {
      val c = if (((b >> i) & 1) == 1) '1' else '_'
      print(c)
    }
  }

  def printScreen(screen: Array[Byte], width: Int): Unit = {
    val height = screen.length * 8 / width
    for (r <- 0 until height) {
      for (c <- 0 until width by 8) {
        val b = screen(computeByteNum(width, c, r))
        printByte(b)
      }
      println()
    }
  }

  def main(args: Array[String]): Unit = {
    val width = 8 * 1
    val height = 1
    for {
      r <- 0 until height
      c1 <- 0 until width
      c2 <- c1 until width
    } {
      val screen = new Array[Byte](width * height / 8)

      println(s"row: $r: $c1 -> $c2")
      drawLine(screen, width, c1, c2, r)
      printScreen(screen, width)
      println("\n\n")
    }
  }
}
