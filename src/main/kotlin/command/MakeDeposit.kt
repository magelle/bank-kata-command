package command

import application.clock
import application.operations
import domain.banking.Deposit

class MakeDeposit(private val amount: Double) {
    fun execute() {
        operations.add(Deposit(amount, clock.now()))
    }
}
