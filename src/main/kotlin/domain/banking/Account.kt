package domain.banking

class Account(private val operations: MutableList<Operation> = mutableListOf()) {

    fun operations() = operations.toList()

    fun add(operation: Operation) {
        operations.add(operation)
    }

    fun balance() = operations.fold(.0, {acc, cur -> when(cur) {
        is Deposit -> acc + cur.amount
        is Withdrawal -> acc - cur.amount
        else -> throw IllegalArgumentException("Unknown operation")
    }})

}