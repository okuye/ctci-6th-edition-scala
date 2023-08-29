package Q16_12_XML_Encoding

class Attribute(val tag: String, val value: String) {

  def getTagCode: String = tag match {
    case "family"     => "1"
    case "person"     => "2"
    case "firstName"  => "3"
    case "lastName"   => "4"
    case "state"      => "5"
    case _            => "--"
  }
}
