package kotlinexample.interaction.transfer

interface TransferRoleCasting {
  fun useSource(roleOrder: TransferRoleOrder): Pair<Source, () -> Unit>
  fun useDestination(roleOrder: TransferRoleOrder): Pair<Destination, () -> Unit>
}
