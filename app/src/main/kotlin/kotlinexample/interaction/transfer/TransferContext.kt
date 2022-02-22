package kotlinexample.interaction.transfer

class TransferContext(
  private val castings: List<TransferRoleCasting>
) {
  fun useSource(roleOrder: TransferRoleOrder) = castings
    .mapNotNull { it.useSource(roleOrder) }
    .first()

  fun useDestination(roleOrder: TransferRoleOrder) = castings
    .mapNotNull { it.useDestination(roleOrder) }
    .first()
}
