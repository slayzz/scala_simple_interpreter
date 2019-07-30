package parser.expression

class PlusExpression(executeFunction: => Int) extends Expression {
  override def interpreter(): Int = executeFunction
}

