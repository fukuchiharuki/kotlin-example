package kotlinexample.data.savingaccount

import kotlin.test.Test
import kotlin.test.assertEquals

class SavingAccountTest {
  @Test fun increasing() {
    val balance = 10
    val amount = 2
    val expected = 12
    val savingAccount = SavingAccount("Neo", balance)
    assertEquals(expected = balance, actual = savingAccount.balance)
    savingAccount.increasesBalance(amount)
    assertEquals(expected = expected, actual = savingAccount.balance)
  }

  @Test fun decreasing() {
    val balance = 10
    val amount = 2
    val expected = 8
    val savingAccount = SavingAccount("Neo", balance)
    assertEquals(expected = balance, actual = savingAccount.balance)
    savingAccount.decreasesBalance(amount)
    assertEquals(expected = expected, actual = savingAccount.balance)
  }
}
