package kotlinexample.interaction.transfer

import kotlinexample.lang.optin.curried

class TransferInteraction(
  private val context: TransferContext
) {
  fun standBy(
    sourceOrder: TransferRoleOrder,
    destinationOrder: TransferRoleOrder,
  ): Pair<(Int) -> Unit, () -> Unit> {
    val (source, finishSource) = context.useSource(sourceOrder)
    val (destination, finishDestination) = context.useDestination(destinationOrder)
    return TransferInteraction::interact.curried()(this)(source)(destination) to
      { finishSource(); finishDestination() }
  }

  private fun interact(source: Source, destination: Destination, amount: Int) {
    source.send(destination, amount)
  }
}
