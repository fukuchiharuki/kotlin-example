package kotlinexample.interaction.transfer

interface TransferRoleOrder {
  fun isMeantFor(roleCasting: TransferRoleCasting): Boolean
  val name: String
}
