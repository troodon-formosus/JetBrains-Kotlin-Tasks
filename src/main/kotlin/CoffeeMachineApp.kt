var amountOfWater = 400
var amountOfMilk = 540
var amountOfCoffee = 120
var amountOfCups = 9
var amountOfMoney = 550

fun printState() {
    val standardInputTemplate = """
        The coffee machine has:
        $amountOfWater ml of water
        $amountOfMilk ml of milk
        $amountOfCoffee g of coffee beans
        $amountOfCups disposable cups
        $$amountOfMoney of money
        
        """.trimIndent()

    println(standardInputTemplate)
}

fun prepareCoffee() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    val userChoice = readln().toInt()
    when (userChoice) {
        1 -> makeEspresso()
        2 -> makeLatte()
        3 -> makeCappuccino()
    }
    amountOfCups -= 1
    println()
}

fun makeEspresso() {
    amountOfWater -= 250
    amountOfCoffee -= 16
    amountOfMoney += 4
}

fun makeLatte() {
    amountOfWater -= 350
    amountOfMilk -= 75
    amountOfCoffee -= 20
    amountOfMoney += 7
}

fun makeCappuccino() {
    amountOfWater -= 200
    amountOfMilk -= 100
    amountOfCoffee -= 12
    amountOfMoney += 6
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

    println()
}

fun retrieveCash() {
    println("I gave you $$amountOfMoney\n")
    amountOfMoney = 0
}

fun main() {
    do {
        print("Write action (buy, fill, take, remaining, exit): ")
        val userInput = readln()
        when (userInput) {
            "buy" -> prepareCoffee()
            "fill" -> replenishMachine()
            "take" -> retrieveCash()
            "remaining" -> printState()
        }
    } while (userInput != "exit")
}
