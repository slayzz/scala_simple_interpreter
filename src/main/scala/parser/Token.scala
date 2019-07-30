package parser

sealed abstract class Token

case class NumberToken(number: Int) extends Token {
  override def toString: String = s"$number"
}

case class PlusToken() extends Token {
  override def toString: String = "+"
}

case class MinusToken() extends Token {
  override def toString: String = "-"
}

case class EndToken() extends Token {
  override def toString: String = "[END]"
}
