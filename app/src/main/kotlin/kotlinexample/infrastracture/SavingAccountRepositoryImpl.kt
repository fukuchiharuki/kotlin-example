package kotlinexample.infrastracture

import kotlinexample.data.savingaccount.SavingAccount
import kotlinexample.data.savingaccount.SavingAccountRepository

class SavingAccountRepositoryImpl : SavingAccountRepository {
  private var list = listOf(
    SavingAccount("Mike", 10),
    SavingAccount("Jane", 10)
  )

  override fun getBy(name: String): SavingAccount? {
    return list.find { it.name == name }
      ?.let { SavingAccount(it.name, it.balance) }
  }

  override fun set(o: SavingAccount) {
    assert(list.any { it.name == o.name })
    list = list.filter { it.name != o.name } + o
  }

  fun log() {
    println("-- Saving Account")
    list.sortedBy { it.name }.forEach { println(it.toString()) }
  }
}
