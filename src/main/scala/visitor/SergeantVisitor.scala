package visitor

import java.util.logging.Logger

class SergeantVisitor extends UnitTypeVisitor {

  import SergeantVisitor._

  override def visitSoldier(soldier: Soldier): Unit = {}

  override def visitSergeant(sergeant: Sergeant): Unit = {
    LOGGER.info(s"Good to see you $sergeant")
  }

  override def visitCommander(commander: Commander): Unit = {}

}

object SergeantVisitor {
  private val LOGGER = Logger.getLogger(SergeantVisitor.getClass.getName)
}
