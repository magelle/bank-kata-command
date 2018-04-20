package command

import application.clock
import application.account
import domain.banking.Deposit

class MakeDeposit(private val amount: Double) {
    fun execute() {
        account.add(Deposit(amount, clock.now()))
    }
}
