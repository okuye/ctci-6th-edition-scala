package Q8_13_Stack_of_Boxes

import java.util.ArrayList
import scala.util.Random

object Tester {
  def createRandomBox(): Box = {
    val r = new Random()
    new Box(r.nextInt(100), r.nextInt(100), r.nextInt(100))
  }

  def main(args: Array[String]): Unit = {
    val boxes1 = new ArrayList[Box]()
    val boxes2 = new ArrayList[Box]()
    val boxes3 = new ArrayList[Box]()
    for (i <- 0 until 200) {
      val b = createRandomBox()
      boxes1.add(b)
      boxes2.add(b)
      boxes3.add(b)
    }

    val height1 = QuestionA.createStack(boxes1)
    val height2 = QuestionB.createStack(boxes2)
    val height3 = QuestionB.createStack(boxes3)
    println(s"$height1, $height2, $height3")
  }
}
