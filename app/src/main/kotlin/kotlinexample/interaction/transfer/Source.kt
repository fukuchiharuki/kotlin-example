package kotlinexample.interaction.transfer

import kotlinexample.data.account.Account

interface Source : Account {
  fun send(to: Destination, amount: Int) {
    if (!hasBalance(amount)) throw Exception("balance was not enough")
    decreasesBalance(amount)
    to.receive(from = this, amount)
  }
}
