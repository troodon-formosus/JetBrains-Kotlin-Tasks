package app

fun main() {
    val currencyRate = readln().toDouble()
    val rubRate = 0.017
    val grossOfUSDPerMonth = readln().toDouble()
    val grossInActualCurrencyPerMonth = grossOfUSDPerMonth / currencyRate
    val grossPerMonthInRub = grossOfUSDPerMonth / rubRate
    println("\t|\tAUD\t\t|\tRUB\t")
    for (i in (1..12)) {
        val thisMonthGrossInActualCurrency = grossInActualCurrencyPerMonth * i
        val thisMonthGrossInRub = grossPerMonthInRub * i
        println("$i\t|\t$thisMonthGrossInActualCurrency\t|\t$thisMonthGrossInRub\t")
    }
}
