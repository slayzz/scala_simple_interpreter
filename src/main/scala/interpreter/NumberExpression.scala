package interpreter

class NumberExpression(val number: Int) extends Expression {
  override def interpret(): Int = number

  def this(number: String) = {
    this(number.toInt)
  }

  override def toString: String = "number"
}
