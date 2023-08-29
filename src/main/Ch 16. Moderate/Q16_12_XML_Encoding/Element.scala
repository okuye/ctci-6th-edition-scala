package Q16_12_XML_Encoding

import scala.collection.mutable.ArrayBuffer

class Element(val name: String, val value: String = null) {
  val attributes: ArrayBuffer[Attribute] = ArrayBuffer()
  val children: ArrayBuffer[Element] = ArrayBuffer()

  def getNameCode: String = name match {
    case "family"     => "1"
    case "person"     => "2"
    case "firstName"  => "3"
    case "lastName"   => "4"
    case "state"      => "5"
    case _            => "--"
  }

  def insert(attribute: Attribute): Unit = attributes += attribute

  def insert(child: Element): Unit = children += child
}
