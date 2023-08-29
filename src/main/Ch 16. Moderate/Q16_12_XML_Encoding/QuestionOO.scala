package Q16_12_XML_Encoding

object QuestionOO {

  def encode(v: String, sb: StringBuilder): Unit = {
    val updatedV = v.replace("0", "\\0")
    sb.append(updatedV)
    sb.append(" ")
  }

  def encodeEnd(sb: StringBuilder): Unit = {
    sb.append("0")
    sb.append(" ")
  }

  def encode(attr: Attribute, sb: StringBuilder): Unit = {
    encode(attr.getTagCode, sb)
    encode(attr.value, sb)
  }

  def encode(root: Element, sb: StringBuilder): Unit = {
    encode(root.getNameCode, sb)
    for (a <- root.attributes) {
      encode(a, sb)
    }
    encodeEnd(sb)
    if (root.value != null && root.value != "") {
      encode(root.value, sb)
    } else {
      for (e <- root.children) {
        encode(e, sb)
      }
    }
    encodeEnd(sb)
  }

  def encodeToString(root: Element): String = {
    val sb = new StringBuilder
    encode(root, sb)
    sb.toString
  }

  def main(args: Array[String]): Unit = {
    val root = new Element("family")
    val a1 = new Attribute("lastName", "mcdowell")
    val a2 = new Attribute("state", "CA")
    root.insert(a1)
    root.insert(a2)

    val child = new Element("person", "Some Message")
    val a3 = new Attribute("firstName", "Gayle")
    child.insert(a3)

    root.insert(child)

    val s = encodeToString(root)
    println(s)
  }
}
