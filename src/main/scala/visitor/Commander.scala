package visitor

class Commander(children: UnitType*) extends UnitType(children : _*) {
  override def accept(visitor: UnitTypeVisitor): Unit = {
    visitor.visitCommander(this)
    super.accept(visitor)
  }

  override def toString: String = "commander"
}
