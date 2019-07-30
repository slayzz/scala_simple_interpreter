package visitor

class Soldier(children: UnitType*) extends UnitType(children : _*) {
  override def accept(visitor: UnitTypeVisitor): Unit = {
    visitor.visitSoldier(this)
    super.accept(visitor)
  }

  override def toString: String = "soldier"
}
