package visitor

import java.util.logging.Logger

class SoldierVisitor extends UnitTypeVisitor {

  import SoldierVisitor._

  override def visitSoldier(soldier: Soldier): Unit = {
    LOGGER.info(s"Good to see you $soldier")
  }

  override def visitSergeant(sergeant: Sergeant): Unit = {
  }

  override def visitCommander(commander: Commander): Unit = {}

}

object SoldierVisitor {
  private val LOGGER = Logger.getLogger(SoldierVisitor.getClass.getName)
}
