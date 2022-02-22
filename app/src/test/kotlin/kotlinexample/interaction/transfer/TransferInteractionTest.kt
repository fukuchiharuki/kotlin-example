package kotlinexample.interaction.transfer

import kotlin.test.Test
import kotlin.test.assertEquals

class TransferInteractionTest {
  @Test fun interact() {
    val inputAmount = 2
    var interactionCallCount = 0
    var closingCallCount = 0

    object : TransferRoleCasting {
      override fun useSource(roleOrder: TransferRoleOrder) =
        object : Source {
          override fun hasBalance(amount: Int): Boolean {
            interactionCallCount++
            assertEquals(expected = inputAmount, actual = amount)
            return true
          }
          override fun increasesBalance(amount: Int) {
            throw Exception("method should not be called")
          }
          override fun decreasesBalance(amount: Int) {
            interactionCallCount++
            assertEquals(expected = inputAmount, actual = amount)
          }
        } to {
          closingCallCount++
          Unit
        }
      override fun useDestination(roleOrder: TransferRoleOrder) =
        object : Destination {
          override fun hasBalance(amount: Int): Boolean {
            throw Exception("method should not be called")
          }
          override fun increasesBalance(amount: Int) {
            interactionCallCount++
            assertEquals(expected = inputAmount, actual = amount)
          }
          override fun decreasesBalance(amount: Int) {
            throw Exception("method should not be called")
          }
        } to {
          closingCallCount++
          Unit
        }
    }
      .let { listOf(it) }
      .let { TransferContext(it) }
      .let { TransferInteraction(it) }
      .standBy(object : TransferRoleOrder {}, object : TransferRoleOrder {})
      .also { (test, close) -> test(inputAmount); close() }

    assertEquals(expected = 3, actual = interactionCallCount)
    assertEquals(expected = 2, actual = closingCallCount)
  }
}
