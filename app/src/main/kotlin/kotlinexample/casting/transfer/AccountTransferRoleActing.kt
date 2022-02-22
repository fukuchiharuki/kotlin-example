package kotlinexample.casting.transfer

import kotlinexample.data.account.Account
import kotlinexample.interaction.transfer.Destination
import kotlinexample.interaction.transfer.Source

interface AccountTransferRoleActing {
  fun Account.asSource(): Source = object : Source, Account by this {}
  fun Account.asDestination(): Destination = object : Destination, Account by this {}
}
