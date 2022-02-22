package kotlinexample.casting.transfer

import kotlinexample.data.savingaccount.SavingAccountRepository
import kotlinexample.interaction.transfer.TransferRoleCasting
import kotlinexample.interaction.transfer.TransferRoleOrder

class SavingAccountTransferRoleCasting(
  private val repository: SavingAccountRepository
) : TransferRoleCasting, SavingAccountTransferRoleActing {
  companion object {
    fun roleOrder(name: String): TransferRoleOrder = object : TransferRoleOrder {
      override fun isMeantFor(roleCasting: TransferRoleCasting) = roleCasting is SavingAccountTransferRoleCasting
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
