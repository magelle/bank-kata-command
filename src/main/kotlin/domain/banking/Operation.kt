package domain.banking

import java.time.LocalDateTime

interface Operation {
    val amount: Double
    val date: LocalDateTime
}