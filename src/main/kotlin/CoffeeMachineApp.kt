var amountOfWater = 400
var amountOfMilk = 540
var amountOfCoffee = 120
var amountOfCups = 9
var amountOfMoney = 550

fun printState() {
    println("""
The coffee machine has:
$amountOfWater ml of water
$amountOfMilk ml of milk
$amountOfCoffee g of coffee beans
$amountOfCups disposable cups
$$amountOfMoney of money
"""
)
}

fun replenishMachine() {
    print("Write how many ml of water do you want to add: ")
    amountOfWater += readln().toInt()

    print("Write how many ml of milk do you want to add: ")
    amountOfMilk += readln().toInt()

    print("Write how many grams of coffee beans do you want to add: ")
    amountOfCoffee += readln().toInt()

    print("Write how many disposable cups of coffee do you want to add: ")
    amountOfCups += readln().toInt()
}

fun retrieveCash() {
    println("I gave you $$amountOfMoney")
    amountOfMoney = 0
}

fun main() {
    printState()

    print("Write action (buy, fill, take): ")
    val userInput = readln()
    when (userInput) {
        "buy" -> println("")
        "fill" -> replenishMachine()
        "take" -> retrieveCash()
    }

    printState()
}
