package parser

import parser.expression.{Expression, MinusExpression, NumberExpression, PlusExpression}

import scala.collection.mutable

class Parser(parseText: String) {
  private val lexer = new LexerIterator(parseText)

  def interpret(): Int = {
    val fifoNumbers = new mutable.ListBuffer[Expression]()
    val fifoOperations = new mutable.Queue[Expression]()

    try {
      for (token <- lexer) {
        token match {
          case NumberToken(n) => fifoNumbers += new NumberExpression(n)
          case _: PlusToken =>
            fifoOperations += new PlusExpression({
              val firstNumber = fifoNumbers.head.interpreter()
              fifoNumbers.remove(0)
              val secondNumber = fifoNumbers.head.interpreter()
              fifoNumbers.remove(0)
              println(s":::->   $firstNumber + $secondNumber = ${firstNumber + secondNumber}")
              firstNumber + secondNumber
            })
          case _: MinusToken =>
            fifoOperations += new MinusExpression({
              val firstNumber = fifoNumbers.head.interpreter()
              fifoNumbers.remove(0)
              val secondNumber = fifoNumbers.head.interpreter()
              fifoNumbers.remove(0)
              println(s":::->   $firstNumber - $secondNumber = ${firstNumber - secondNumber}")
              firstNumber - secondNumber
            })
          case _: EndToken =>
        }
      }

      for (expression <- fifoOperations) {
        fifoNumbers.insert(0, new NumberExpression(expression.interpreter()))
      }
    } catch {
      case _: Exception =>
        println(":::Error::: Wrong Syntax")
        System.exit(10)
    }

    val result = fifoNumbers.head.interpreter()
    println(s"\n\nResult: $result")
    result
  }

}
