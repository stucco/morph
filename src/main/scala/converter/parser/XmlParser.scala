package converter.parser

import converter.ast._

import org.json.{XML, JSONException}

/** Implements an XML parser that constructs an AST.
  *
  * This parser follows the guidelines available at
  * www.xml.com/pub/a/2006/05/31/converting-between-xml-and-json.html
  *
  * Instead of implementing an XML parser from scratch, this
  * parser uses an already existing implementation of an XML
  * parser to convert XML to JSON, and then uses the
  * converter.parser.JsonParser to convert that to a native AST.
  *
  * XML attributes are prepended with an `@`, and content can be found
  * in `#text`.
  *
  * Arrays will be transformed to JSON arrays.
  *
  * @author Anish Athalye
  */
object XmlParser extends AstBuilder {

  /** The main parsing method.
    *
    * @param input The content to parse.
    *
    * @return The root of the generated AST.
    */
  def apply(input: String) = {
    try {
      val json = XML toJSONObject input toString 0
      JsonParser(json) // to get the XML in native AST form
    } catch {
      case ex: JSONException => throw ParsingException(ex.getMessage)
    }
  }

  /** The main parsing method.
    *
    * @param input The content to parse.
    *
    * @return The root of the generated AST.
    */
  def apply(input: Array[Char]) = apply(input.mkString)
}
