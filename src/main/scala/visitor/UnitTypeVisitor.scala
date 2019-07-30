package visitor

trait UnitTypeVisitor {
  def visitSoldier(soldier: Soldier)
  def visitSergeant(sergeant: Sergeant)
  def visitCommander(commander: Commander)
}
