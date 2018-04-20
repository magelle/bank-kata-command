package application

import command.MakeDeposit
import command.Withdraw
import domain.banking.Operation
import infra.Clock
import query.GetStatement

var operations = mutableListOf<Operation>()
var clock = Clock()

fun makeADepositOf(amount: Double) = MakeDeposit(amount)

fun withdraw(amount: Double) = Withdraw(amount)

fun getStatement() = GetStatement()