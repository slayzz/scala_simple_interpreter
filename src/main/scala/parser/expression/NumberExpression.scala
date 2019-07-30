package parser.expression

class NumberExpression(number: Int) extends Expression {
  override def interpreter(): Int = number
}
