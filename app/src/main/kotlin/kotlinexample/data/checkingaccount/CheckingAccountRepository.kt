package kotlinexample.data.checkingaccount

interface CheckingAccountRepository {
  fun getBy(name: String): CheckingAccount?
  fun set(o: CheckingAccount)
}
