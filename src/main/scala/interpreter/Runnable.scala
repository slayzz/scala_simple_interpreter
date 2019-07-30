package interpreter

import java.util.logging.Logger

import scala.collection.mutable

object Runnable {
  private val LOGGER = Logger.getLogger("Interpreter App")

  def run(tokenString: String): Unit = {
    val stack: mutable.Stack[Expression] = new mutable.Stack()

    val tokenList = tokenString.split(" ")

    for (s <- tokenList) {
      if (isOperator(s)) {
        val rightExpression = stack.pop
        val leftExpression = stack.pop

        LOGGER.info(s"popped from stack left: ${leftExpression.interpret()} right: ${rightExpression.interpret()}")
        val operator = getOperatorInstance(s, leftExpression, rightExpression)
        LOGGER.info(s"operator: $operator")

        val result = operator.interpret()
        val resultExpression = new NumberExpression(result)
        stack.push(resultExpression)

        LOGGER.info(s"push result to stack: ${resultExpression.interpret()}")
      } else {
        LOGGER.info(s"Got new expression: $s")
        val i = new NumberExpression(s)
        stack.push(i)
        LOGGER.info(s"push to stack: ${i.interpret()}")
      }
    }
    LOGGER.info(s"result: ${stack.pop.interpret()}")
  }

  private def getOperatorInstance(s: String, left: Expression, right: Expression): Expression =
    s match {
      case "+" => new PlusExpression(left, right)
      case "-" => new MinusExpression(left, right)
      case _ => new PlusExpression(left, right)
    }

  private def isOperator(s: String): Boolean = s == "+" || s == "-"
}
