package parser.expression

class MinusExpression(executeFunction: => Int) extends Expression {
  override def interpreter(): Int = executeFunction
}
