package domain.banking

import java.time.LocalDateTime

class Deposit(override val amount: Double, override val date: LocalDateTime) : Operation {
    init {
        check(amount > 0)
    }
}
