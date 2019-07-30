package visitor

class UnitType(childrenAll: UnitType*) {
  private val children = childrenAll

  def accept(visitor: UnitTypeVisitor): Unit =
    children.foreach(child =>  child.accept(visitor))
}
