package kotlinexample.data.savingaccount

import kotlinexample.data.account.Account

class SavingAccount(
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
