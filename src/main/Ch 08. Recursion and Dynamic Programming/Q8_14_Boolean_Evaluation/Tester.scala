package Q8_14_Boolean_Evaluation

import scala.collection.mutable.HashMap
import scala.util.Random

object Tester {

  def allEqual(map: HashMap[String, Int]): Boolean = {
    var valOpt: Option[Int] = None
    for ((_, v) <- map) {
      valOpt match {
        case Some(value) if value != v => return false
        case _ => valOpt = Some(v)
      }
    }
    true
  }

  def getRandomOperator: Char = {
    val ops = Array('^', '&', '|')
    ops(Random.nextInt(3))
  }

  def getRandomExpression: String = {
    val len = Random.nextInt(10) * 2 + 1
    (for (i <- 0 until len) yield {
      if (i % 2 == 0) {
        if (Random.nextBoolean()) '1' else '0'
      } else {
        getRandomOperator
      }
    }).mkString
  }

  def main(args: Array[String]): Unit = {
    for (_ <- 0 until 50) {
      val terms = getRandomExpression
      val result = true

      val oBF = Others.bruteForce(terms, HashMap[String, Boolean](), result, Array.fill[Boolean]((terms.length - 1) / 2)(false))
      val oR = Others.countR(terms, result, 0, terms.length - 1)
      val oDP = Others.countDP(terms, result, 0, terms.length - 1, HashMap[String, Int]())
      val oDPEFF = Others.countDPEff(terms, result, 0, terms.length - 1, HashMap[String, Int]())

      val a = QuestionA.countEval(terms, result)
      val b = QuestionB.countEval(terms, result)

      val results = HashMap[String, Int](
        "oBF" -> oBF,
        "oR" -> oR,
        "oDP" -> oDP,
        "oDPEFF" -> oDPEFF,
        "a" -> a,
        "b" -> b
      )

      if (allEqual(results)) {
        println(s"Success: $terms->$b")
        println(results.toString())
      } else {
        println(s"Failure: $terms")
        println(results.toString())
        return
      }
    }
  }
}
