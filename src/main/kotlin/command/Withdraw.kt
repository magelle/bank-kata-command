package command

import application.clock
import application.operations
import domain.banking.Withdrawal

class Withdraw(private val amount: Double) {
    fun execute() {
        operations.add(Withdrawal(amount, clock.now()))
    }
}
