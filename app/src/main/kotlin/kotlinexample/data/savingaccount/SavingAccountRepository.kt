package kotlinexample.data.savingaccount

interface SavingAccountRepository {
  fun getBy(name: String): SavingAccount?
  fun set(o: SavingAccount)
}
