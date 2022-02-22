package kotlinexample.interaction.transfer

import kotlinexample.data.account.Account

interface Destination : Account {
  fun receive(from: Source, amount: Int) {
    increasesBalance(amount)
  }
}
