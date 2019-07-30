package parser.factory

import parser.{EndToken, MinusToken, NumberToken, PlusToken, Token}

class TokenFactoryImpl extends TokenFactory {
  override def createNumber(str: String): Token = new NumberToken(str.toInt)

  override def createPlus: Token = new PlusToken

  override def createMinus: Token = new MinusToken

  override def createEnd: Token = new EndToken
}
