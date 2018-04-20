package query

import application.operations
import domain.banking.Deposit
import domain.banking.Operation
import domain.banking.Withdrawal
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetStatement {
    fun query(): String {
        var balance = .0
        return "date;credit;debit;balance\n${operations
                .sortedBy { op -> op.date }
                .asSequence()
                .map { op ->
                    balance = aggregateBalance(op, balance)
                    statementLine(op, balance)
                }
                .asIterable()
                .reversed()
                .reduce { acc, line -> acc + line }
        }"
    }

    private fun aggregateBalance(op: Operation, balance: Double): Double {
        return when (op) {
            is Deposit -> balance + op.amount
            is Withdrawal -> balance - op.amount
            else -> throw IllegalArgumentException("Unknown operation")
        }
    }

    private fun statementLine(op: Operation, balance: Double): String {
        return when (op) {
            is Deposit -> "${op.date.format()};${op.amount.format()};;${balance.format()}\n"
            is Withdrawal -> "${op.date.format()};;${op.amount.format()};${balance.format()}\n"
            else -> throw IllegalArgumentException("Unknown operation")
        }
    }

    private fun Double.format() =
            DecimalFormat("#.00").format(this)!!

    private fun LocalDateTime.format() =
            DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this)!!
}
