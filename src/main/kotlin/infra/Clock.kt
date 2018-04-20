package infra

import java.time.LocalDateTime

open class Clock {
    open fun now() = LocalDateTime.now()!!
}
