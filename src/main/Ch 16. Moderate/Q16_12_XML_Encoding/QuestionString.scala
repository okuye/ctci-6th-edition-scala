package Q16_12_XML_Encoding

import Q16_12_XML_Encoding.QuestionString.END

import java.io.{ByteArrayOutputStream, IOException}
import scala.collection.mutable

object QuestionString {
  private val END: Array[Byte] = Array(0.toByte, 1.toByte)
  def main(args: Array[String]): Unit = {
    try {
      val tagMap = mutable.HashMap[String, Byte](
        "a" -> 10,
        "root" -> 11,
        "href" -> 20,
        "target" -> 21,
        "name" -> 50,
        "id" -> 51
      )

      val encoder = new QuestionString(tagMap)
      var input: String = ""
      var output: Array[Byte] = Array()

      input = "<root></root>"
      output = encoder.encode(input.toCharArray)
      customPrint(output)

      input = "<root id=a />"
      output = encoder.encode(input.toCharArray)
      customPrint(output)

      input = "<root><a href=abc id=xyz></a><a></a></root>"
      output = encoder.encode(input.toCharArray)
      customPrint(output)
    } catch {
      case ex: Exception => println(ex)
    }
  }

  def customPrint(output: Array[Byte]): Unit = {
    output.foreach(b => {
      print(b)
      print(" ")
    })
    println()
  }
}


class QuestionString(tagMap: mutable.Map[String, Byte]) {

  private var tokens: mutable.ArrayBuffer[String] = mutable.ArrayBuffer()
  private var currentTokenIndex: Int = 0

  def encode(input: Array[Char]): Array[Byte] = {
    tokenize(input)
    currentTokenIndex = 0

    val outputStream = new ByteArrayOutputStream()
    encodeTokens(outputStream)
    outputStream.toByteArray
  }

  private def encodeTokens(output: ByteArrayOutputStream): Unit = {
    nextToken("<")

    val tagName = nextToken()
    output.write(getTagCode(tagName).toByte)

    while (!hasNextToken(">") && !hasNextTokens("/", ">")) {
      val key = nextToken()
      nextToken("=")
      val value = nextToken()

      output.write(getTagCode(key).toByte)
      value.toCharArray.foreach(c => output.write(c.toByte))
      output.write(END(0))
      output.write(END(1))
    }

    output.write(END(0))
    output.write(END(1))

    if (hasNextTokens("/", ">")) {
      nextToken("/")
      nextToken(">")
    } else {
      nextToken(">")
      while (!hasNextTokens("<", "/")) {
        encodeTokens(output)
      }
      nextToken("<")
      nextToken("/")
      nextToken(tagName)
      nextToken(">")
    }

    output.write(END(0))
    output.write(END(1))
  }

  private def nextToken(): String = {
    if (currentTokenIndex >= tokens.size) {
      throw new IOException("Unexpected end of input.")
    }

    val token = tokens(currentTokenIndex)
    currentTokenIndex += 1
    token
  }

  private def nextToken(expectedToken: String): Unit = {
    if (currentTokenIndex >= tokens.size) {
      throw new IOException("Unexpected end of input.")
    }

    val token = tokens(currentTokenIndex)
    if (token == expectedToken) {
      currentTokenIndex += 1
    } else {
      throw new IOException(s"Unexpected input. Expected '$expectedToken'; found '$token'.")
    }
  }

  private def hasNextToken(expectedToken: String): Boolean = {
    if (currentTokenIndex < tokens.size) {
      tokens(currentTokenIndex) == expectedToken
    } else {
      false
    }
  }

  private def hasNextTokens(expectedTokens: String*): Boolean = {
    if (currentTokenIndex + expectedTokens.length > tokens.size) {
      false
    } else {
      expectedTokens.indices.forall(i => tokens(currentTokenIndex + i) == expectedTokens(i))
    }
  }

  private def tokenize(input: Array[Char]): Unit = {
    tokens.clear()
    var i = 0
    while (i < input.length) {
      i = setNextToken(input, i)
    }
  }

  private def setNextToken(input: Array[Char], inputIndex: Int): Int = {
    var i = inputIndex
    while (i < input.length && input(i) == ' ') i += 1
    if (i == input.length) return i

    val c = input(i)
    if (c == '<' || c == '>' || c == '=' || c == '/') {
      tokens += c.toString
      i + 1
    } else {
      val string = new StringBuilder()
      do {
        string.append(c)
        i += 1
        if (i == input.length) {
          return i
        }
      } while (input(i) != '<' && input(i) != '>' && input(i) != '=' && input(i) != '/' && input(i) != ' ')
      tokens += string.toString()
      i
    }
  }

  private def getTagCode(tag: String): Byte = {
    tagMap.getOrElse(tag, throw new IOException(s"Unknown tag: $tag"))
  }
}
