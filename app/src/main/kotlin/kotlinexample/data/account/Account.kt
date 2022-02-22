package kotlinexample.data.account

interface Account {
  fun increasesBalance(amount: Int)
  fun decreasesBalance(amount: Int)
}
