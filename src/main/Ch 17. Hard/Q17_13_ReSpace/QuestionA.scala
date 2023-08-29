package Q17_13_ReSpace

import CtCILibrary.AssortedMethods

import scala.collection.mutable.HashSet

object QuestionA {

  def bestSplit(dictionary: HashSet[String], sentence: String): String = {
    val r = split(dictionary, sentence, 0)
    if (r == null) null else r.parsed
  }

  def split(
      dictionary: HashSet[String],
      sentence: String,
      start: Int
  ): ParseResult = {
    if (start >= sentence.length) return new ParseResult(0, "")

    var bestInvalid = Int.MaxValue
    var bestParsing: String = null

    var partial = ""
    var index = start
    while (index < sentence.length) {
      val c = sentence.charAt(index)
      partial += c
      val invalid = if (dictionary.contains(partial)) 0 else partial.length
      if (invalid < bestInvalid) {
        val result = split(dictionary, sentence, index + 1)
        if (invalid + result.invalid < bestInvalid) {
          bestInvalid = invalid + result.invalid
          bestParsing = s"$partial ${result.parsed}"
          if (bestInvalid == 0) return new ParseResult(bestInvalid, bestParsing)
        }
      }
      index += 1
    }
    new ParseResult(bestInvalid, bestParsing)
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

    var sentence = "As one of the top companies in the world, Google"
    sentence = clean(sentence)
    println(sentence)
    println(bestSplit(dictionary, sentence))
  }

}
