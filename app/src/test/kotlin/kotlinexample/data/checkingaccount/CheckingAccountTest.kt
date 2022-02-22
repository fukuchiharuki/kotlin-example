package kotlinexample.data.checkingaccount

import kotlin.test.Test
import kotlin.test.assertEquals

class CheckingAccountTest {
  @Test fun increasing() {
    val balance = 10
    val amount = 2
    val expected = 12
    val checkingAccount = CheckingAccount("Neo", balance)
    assertEquals(expected = balance, actual = checkingAccount.balance)
    checkingAccount.increasesBalance(amount)
    assertEquals(expected = expected, actual = checkingAccount.balance)
  }

  @Test fun decreasing() {
    val balance = 10
    val amount = 2
    val expected = 8
    val checkingAccount = CheckingAccount("Neo", balance)
    assertEquals(expected = balance, actual = checkingAccount.balance)
    checkingAccount.decreasesBalance(amount)
    assertEquals(expected = expected, actual = checkingAccount.balance)
  }
}
