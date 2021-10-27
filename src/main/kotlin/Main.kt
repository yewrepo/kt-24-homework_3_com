fun main() {
    val v = 1500_00
    val total = 80_000_00

    printValues(v, calculateCommission(v, total))
    printValues(v, calculateCommission(v, total, CardType.VISA))
    printValues(v, calculateCommission(v, total, CardType.MAESTRO))
}

private fun printValues(amount: Int, commissionValue: Int) {
    println("сумма: ${amount / 100} руб, комиссия: ${commissionValue / 100} руб")
}

fun calculateCommission(value: Int, totalTransfer: Int, type: CardType = CardType.VK_PAY): Int {
    return when (type) {
        CardType.VK_PAY -> PaymentVK.getCommission(value, totalTransfer)
        CardType.VISA,
        CardType.MIR -> PaymentVisaOrMir.getCommission(value, totalTransfer)
        CardType.MASTERCARD,
        CardType.MAESTRO -> PaymentMaestroOrMastercard.getCommission(value, totalTransfer)
    }
}