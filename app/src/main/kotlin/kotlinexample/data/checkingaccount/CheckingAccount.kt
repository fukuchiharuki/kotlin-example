package kotlinexample.data.checkingaccount

import kotlinexample.data.account.Account

class CheckingAccount(
  val name: String,
  private var _balance: Int
) : Account {
  val balance: Int get() = this._balance

  override fun increasesBalance(amount: Int) {
    _balance += amount
  }

  override fun decreasesBalance(amount: Int) {
    _balance -= amount
  }

  override fun toString() = "{name=$name, balance=$balance}"
}
