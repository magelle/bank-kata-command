import application.*
import assertk.assert
import assertk.assertions.isEqualTo
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Test
import java.time.LocalDateTime

class BankFeatureTest {

    @Test
    fun `should print statement when asked`() {
        operations = mutableListOf()
        clock = mock()
        whenever(clock.now()).thenReturn(
                LocalDateTime.of(2012, 1, 10, 0, 0, 0),
                LocalDateTime.of(2012, 1, 13, 0, 0, 0),
                LocalDateTime.of(2012, 1, 14, 0, 0, 0)
        )
        makeADepositOf(1_000.00).execute()
        makeADepositOf(2_000.0).execute()
        withdraw(500.00).execute()

        val printedStatement = getStatement().query()

        assert(printedStatement)
                .isEqualTo("date;credit;debit;balance\n" +
                        "14/01/2012;;500,00;2500,00\n" +
                        "13/01/2012;2000,00;;3000,00\n" +
                        "10/01/2012;1000,00;;1000,00\n")
    }

}