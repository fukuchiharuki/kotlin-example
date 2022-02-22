package kotlinexample

class ConsoleArguments(
  private val args: Array<String>
) : App.Command {
  override val sourceOrder get() = ResourceType.valueOf(args[0]).roleOrder(args[1])
  override val destinationOrder get() = ResourceType.valueOf(args[2]).roleOrder(args[3])
  override val amount get() = args[4].toInt()
}
