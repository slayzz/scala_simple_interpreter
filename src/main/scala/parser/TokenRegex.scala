package parser

import scala.util.matching.Regex

object TokenRegex extends Enumeration {
  protected case class Val(regex: Regex) extends super.Val

  val NUMBER = Val("\\d".r)
  val PLUS = Val("\\+".r)
  val MINUS = Val("-".r)
  val EMPTY = Val("\\s|\t|\n".r)
  val ANY = Val("\\w".r)
}
