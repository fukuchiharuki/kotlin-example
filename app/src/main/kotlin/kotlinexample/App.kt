package kotlinexample

import kotlinexample.casting.transfer.CheckingAccountTransferRoleCasting
import kotlinexample.casting.transfer.SavingAccountTransferRoleCasting
import kotlinexample.infrastracture.CheckingAccountRepositoryImpl
import kotlinexample.infrastracture.SavingAccountRepositoryImpl
import kotlinexample.interaction.transfer.TransferContext
import kotlinexample.interaction.transfer.TransferInteraction
import kotlinexample.interaction.transfer.TransferRoleCasting
import kotlinexample.interaction.transfer.TransferRoleOrder

class App {
  private val checkingAccountRepository = CheckingAccountRepositoryImpl()
  private val savingAccountRepository = SavingAccountRepositoryImpl()
  private val castings = listOf<TransferRoleCasting>(
    CheckingAccountTransferRoleCasting(checkingAccountRepository),
    SavingAccountTransferRoleCasting(savingAccountRepository),
  )

  interface Command {
    val sourceOrder: TransferRoleOrder
    val destinationOrder: TransferRoleOrder
    val amount: Int
  }

  operator fun invoke(command: Command) {
    checkingAccountRepository.log()
    savingAccountRepository.log()
    executeTransfer(command)
    checkingAccountRepository.log()
    savingAccountRepository.log()
  }

  private fun executeTransfer(command: Command) {
    TransferInteraction(TransferContext(castings))
      .standBy(sourceOrder = command.sourceOrder, destinationOrder = command.destinationOrder)
      .also { (interact, close) ->
        interact(command.amount)
        close()
      }
  }
}
