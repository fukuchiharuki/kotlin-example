package kotlinexample

import kotlinexample.casting.transfer.CheckingAccountTransferRoleCasting
import kotlinexample.casting.transfer.SavingAccountTransferRoleCasting
import kotlinexample.interaction.transfer.TransferRoleOrder

enum class ResourceType {
  CheckingAccount,
  SavingAccount,
  ;

  fun roleOrder(name: String): TransferRoleOrder {
    return when (this) {
      CheckingAccount -> CheckingAccountTransferRoleCasting.roleOrder(name)
      SavingAccount -> SavingAccountTransferRoleCasting.roleOrder(name)
    }
  }
}
