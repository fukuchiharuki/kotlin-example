package kotlinexample.casting.transfer

import kotlinexample.data.account.Account
import kotlinexample.data.checkingaccount.CheckingAccount
import kotlinexample.interaction.transfer.Destination
import kotlinexample.interaction.transfer.Source

interface CheckingAccountTransferRoleActing {
  fun CheckingAccount.asSource(): Source = object : Source, Account by this {}
  fun CheckingAccount.asDestination(): Destination = object : Destination, Account by this {}
}
