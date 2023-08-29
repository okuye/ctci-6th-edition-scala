package Q17_13_ReSpace

import CtCILibrary.AssortedMethods

import scala.collection.mutable.HashSet

object QuestionB {

  def bestSplit(dictionary: HashSet[String], sentence: String): String = {
    val memo = Array.ofDim[ParseResult](sentence.length)
    val r = split(dictionary, sentence, 0, memo)
    if (r == null) null else r.parsed
  }

  def split(
      dictionary: HashSet[String],
      sentence: String,
      start: Int,
      memo: Array[ParseResult]
  ): ParseResult = {
    if (start >= sentence.length) return new ParseResult(0, "")
    if (memo(start) != null) return memo(start)

    var bestInvalid = Int.MaxValue
    var bestParsing: String = null

    var partial = ""
    var index = start
    while (index < sentence.length) {
      val c = sentence.charAt(index)
      partial += c
      val invalid = if (dictionary.contains(partial)) 0 else partial.length
      if (invalid < bestInvalid) {
        val result = split(dictionary, sentence, index + 1, memo)
        if (invalid + result.invalid < bestInvalid) {
          bestInvalid = invalid + result.invalid
          bestParsing = s"$partial ${result.parsed}"
          if (bestInvalid == 0)
            return new ParseResult(bestInvalid, bestParsing) // Short circuit
        }
      }
      index += 1
    }
    memo(start) = new ParseResult(bestInvalid, bestParsing)
    memo(start)
  }

  def clean(str: String): String = {
    val punctuation = List(',', '"', '!', '.', '\'', '?', ',')
    punctuation
      .foldLeft(str)((current, c) => current.replace(c, ' '))
      .replace(" ", "")
      .toLowerCase
  }

  def main(args: Array[String]): Unit = {
    val dictionary = scala.collection.mutable
      .HashSet[String]() ++ AssortedMethods.getWordListAsHashSet
    var sentence =
      "As one of the topk companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone."
    sentence = clean(sentence)
    println(sentence)
    println(bestSplit(dictionary, sentence))
  }

}
