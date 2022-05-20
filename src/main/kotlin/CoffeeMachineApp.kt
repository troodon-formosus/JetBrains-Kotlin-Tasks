var amountOfWater = 400
var amountOfMilk = 540
var amountOfCoffee = 120
var amountOfCup = 9
var amountOfMoney = 550

fun printState() {
    println("""
The coffee machine has:
$amountOfWater ml of water
$amountOfMilk ml of milk
$amountOfCoffee g of coffee beans
$amountOfCup disposable cups
$$amountOfMoney of money
"""
)
}

fun retrieveCash() {
    println("I gave you $$amountOfMoney")
    amountOfMoney = 0
}

fun main() {
    printState()

    println("Write action (buy, fill, take):")
    val userInput = readln()
    when (userInput) {
        "buy" -> println("")
        "fill" -> println("")
        "take" -> retrieveCash()
    }

    printState()
}
