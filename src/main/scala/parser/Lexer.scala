package parser

import util.control.Breaks._
import scala.util.matching.Regex
import parser.factory.TokenFactoryImpl
import parser.EndToken

class Lexer(parseString: String) {
  private val bytes = parseString.getBytes
  private val tokenFactory = new TokenFactoryImpl()
  private var currentIndex = 0

  def getNextToken: Token = {
    val stringBuilder = new StringBuilder()

    if (currentIndex >= bytes.length) {
      tokenFactory.createEnd
    }

    while (currentIndex < bytes.length) {
      breakable {
        val char = bytes(currentIndex).toChar

        if (isToken(char, TokenRegex.EMPTY.regex)) {
          currentIndex += 1
          break
        } else if (isToken(char, TokenRegex.NUMBER.regex)) {
          var index = currentIndex
          var ch = bytes(index).toChar
          while (isToken(ch, TokenRegex.NUMBER.regex) && index < bytes.length) {
            stringBuilder.append(ch)
            index += 1
            if (index < bytes.length) {
              ch = bytes(index).toChar
            }
          }
          currentIndex = index
          return tokenFactory.createNumber(stringBuilder.toString())
        } else if (isToken(char, TokenRegex.MINUS.regex)) {
          currentIndex += 1
          return tokenFactory.createMinus
        } else if (isToken(char, TokenRegex.PLUS.regex)) {
          currentIndex += 1
          return tokenFactory.createPlus
        } else if (isToken(char, TokenRegex.ANY.regex)) {
          currentIndex += 1
        }
      }
    }
    tokenFactory.createEnd
  }

  def isToken(char: Char, regex: Regex): Boolean = {
    (regex findFirstMatchIn char.toString).isDefined
  }
}

class LexerIterator(str: String) extends Lexer(str) with Iterator[Token] {
  private var currentToken: Token = _

  override def hasNext: Boolean = {
    if (currentToken == null || currentToken != new EndToken) {
      return true
    }
    false
  }

  override def next(): Token = {
    currentToken = getNextToken
    currentToken
  }
}
