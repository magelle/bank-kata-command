package domain.banking

import java.time.LocalDateTime

data class Withdrawal(override val amount: Double,override  val date: LocalDateTime) : Operation{
    init {
        check(amount > 0)
    }
}
