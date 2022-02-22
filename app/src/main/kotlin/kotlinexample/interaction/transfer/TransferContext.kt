package kotlinexample.interaction.transfer

class TransferContext(
  private val roleMappings: List<TransferRoleCasting>
) {
  fun useSource(roleOrder: TransferRoleOrder) = roleMappings
    .first { roleOrder.isMeantFor(it) }
    .useSource(roleOrder)

  fun useDestination(roleOrder: TransferRoleOrder) = roleMappings
    .first { roleOrder.isMeantFor(it) }
    .useDestination(roleOrder)
}
