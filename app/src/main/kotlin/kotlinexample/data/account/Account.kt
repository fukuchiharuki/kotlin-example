package kotlinexample.data.account

interface Account {
  fun hasBalance(amount: Int): Boolean
  fun increasesBalance(amount: Int)
  fun decreasesBalance(amount: Int)
}
