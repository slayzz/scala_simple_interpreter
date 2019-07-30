package visitor

import java.util.logging.Logger

class CommanderVisitor extends UnitTypeVisitor {

  import CommanderVisitor._

  override def visitSoldier(soldier: Soldier): Unit = {}

  override def visitSergeant(sergeant: Sergeant): Unit = {}

  override def visitCommander(commander: Commander): Unit = {
    LOGGER.info(s"Good to see you $commander")
  }
}

object CommanderVisitor {
  private val LOGGER = Logger.getLogger(CommanderVisitor.getClass.getName)
}
