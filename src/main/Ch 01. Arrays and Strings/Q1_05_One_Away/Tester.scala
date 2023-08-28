package Q1_05_One_Away

object Tester {

  def test(a: String, b: String, expected: Boolean): Unit = {
    val resultA = QuestionA.oneEditAway(a, b)
    val resultB = QuestionB.oneEditAway(a, b)

    if (resultA == expected && resultB == expected) {
      println(s"$a, $b: success")
    } else {
      println(s"$a, $b: error")
    }
  }

  def main(args: Array[String]): Unit = {
    val tests = Array(
      ("a", "b", true),
      ("", "d", true),
      ("d", "de", true),
      ("pale", "pse", false),
      ("acdsfdsfadsf", "acdsgdsfadsf", true),
      ("acdsfdsfadsf", "acdsfdfadsf", true),
      ("acdsfdsfadsf", "acdsfdsfads", true),
      ("acdsfdsfadsf", "cdsfdsfadsf", true),
      ("adfdsfadsf", "acdfdsfdsf", false),
      ("adfdsfadsf", "bdfdsfadsg", false),
      ("adfdsfadsf", "affdsfads", false),
      ("pale", "pkle", true),
      ("pkle", "pable", false)
    )

    for ((a, b, expected) <- tests) {
      test(a, b, expected)
      test(b, a, expected)
    }
  }

}
