package command

import application.clock
import application.account
import domain.banking.Withdrawal

class Withdraw(private val amount: Double) {
    fun execute() {
        if (account.balance() >= amount) {
            account.add(Withdrawal(amount, clock.now()))
        }
    }
}
