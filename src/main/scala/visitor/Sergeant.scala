package visitor

class Sergeant(children: UnitType*) extends UnitType(children : _*) {
  override def accept(visitor: UnitTypeVisitor): Unit = {
    visitor.visitSergeant(this)
    super.accept(visitor)
  }

  override def toString: String = "sergeant"
}
