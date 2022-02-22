package kotlinexample.interaction.transfer

import kotlinexample.data.account.Account

interface Source : Account {
  fun send(to: Destination, amount: Int) {
    decreasesBalance(amount)
    to.receive(from = this, amount)
  }
}
