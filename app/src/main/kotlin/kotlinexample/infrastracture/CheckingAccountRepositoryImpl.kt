package kotlinexample.infrastracture

import kotlinexample.data.checkingaccount.CheckingAccount
import kotlinexample.data.checkingaccount.CheckingAccountRepository

class CheckingAccountRepositoryImpl : CheckingAccountRepository {
  private var list = listOf(
    CheckingAccount("Mike", 100),
    CheckingAccount("Jane", 100)
  )

  override fun getBy(name: String): CheckingAccount? {
    return list.find { it.name == name }
      ?.let { CheckingAccount(it.name, it.balance) }
  }

  override fun set(o: CheckingAccount) {
    assert(list.any { it.name == o.name })
    list = list.filter { it.name != o.name } + o
  }

  fun log() {
    println("-- Checking Account")
    list.sortedBy { it.name }.forEach { println(it.toString()) }
  }
}
