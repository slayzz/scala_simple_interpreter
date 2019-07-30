package parser.factory

import parser.Token

abstract class TokenFactory {
  def createNumber(str: String): Token
  def createPlus: Token
  def createMinus: Token
  def createEnd: Token
}
