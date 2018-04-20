package command

import application.clock
import application.account
import domain.banking.Withdrawal

class Withdraw(private val amount: Double) {
    fun execute() {
        if (hasEnough()) {
            account.add(Withdrawal(amount, clock.now()))
        }
    }

    private fun hasEnough() = account.balance() >= amount
}
