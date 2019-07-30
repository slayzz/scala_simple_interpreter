package interpreter

class MinusExpression(val leftExpression: Expression, val rightExpression: Expression) extends Expression {
  override def interpret(): Int = leftExpression.interpret() - rightExpression.interpret()

  override def toString: String = "-"
}
