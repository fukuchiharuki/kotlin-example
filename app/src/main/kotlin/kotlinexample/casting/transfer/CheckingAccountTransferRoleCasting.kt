package kotlinexample.casting.transfer

import kotlinexample.data.checkingaccount.CheckingAccountRepository
import kotlinexample.interaction.transfer.TransferRoleCasting
import kotlinexample.interaction.transfer.TransferRoleOrder

class CheckingAccountTransferRoleCasting(
  private val repository: CheckingAccountRepository
) : TransferRoleCasting, CheckingAccountTransferRoleActing {
  companion object {
    fun roleOrder(name: String): TransferRoleOrder = object : TransferRoleOrder {
      override fun isMeantFor(roleCasting: TransferRoleCasting) = roleCasting is CheckingAccountTransferRoleCasting
      override val name: String get() = name
    }
  }

  override fun useSource(roleOrder: TransferRoleOrder) = repository.getBy(roleOrder.name)!!.let {
    it.asSource() to { repository.set(it) }
  }

  override fun useDestination(roleOrder: TransferRoleOrder) = repository.getBy(roleOrder.name)!!.let {
    it.asDestination() to { repository.set(it) }
  }
}
