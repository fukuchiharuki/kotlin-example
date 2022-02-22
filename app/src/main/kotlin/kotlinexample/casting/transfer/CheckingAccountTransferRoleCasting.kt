package kotlinexample.casting.transfer

import kotlinexample.data.checkingaccount.CheckingAccountRepository
import kotlinexample.interaction.transfer.TransferRoleCasting
import kotlinexample.interaction.transfer.TransferRoleOrder

class CheckingAccountTransferRoleCasting(
  private val repository: CheckingAccountRepository
) : TransferRoleCasting, AccountTransferRoleActing {
  data class RoleOrder(
    val name: String
  ) : TransferRoleOrder

  companion object {
    fun roleOrder(name: String): TransferRoleOrder = RoleOrder(name)
  }

  override fun useSource(roleOrder: TransferRoleOrder) =
    (roleOrder as? RoleOrder)
      ?.let { repository.getBy(roleOrder.name) }
      ?.let { it.asSource() to { repository.set(it) } }

  override fun useDestination(roleOrder: TransferRoleOrder) =
    (roleOrder as? RoleOrder)
      ?.let { repository.getBy(roleOrder.name) }
      ?.let { it.asDestination() to { repository.set(it) } }
}
