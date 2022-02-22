package kotlinexample.casting.transfer

import kotlinexample.data.account.Account
import kotlinexample.data.savingaccount.SavingAccount
import kotlinexample.interaction.transfer.Destination
import kotlinexample.interaction.transfer.Source

interface SavingAccountTransferRoleActing {
  fun SavingAccount.asSource(): Source = object : Source, Account by this {}
  fun SavingAccount.asDestination(): Destination = object : Destination, Account by this {}
}
