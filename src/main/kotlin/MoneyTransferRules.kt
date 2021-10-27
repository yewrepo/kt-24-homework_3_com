sealed class MoneyTransferRules(
    val commissionRate: Double = 0.0,
    val additional: Int = 0,
    val commissionMin: Int = 0,
    val commissionStart: Int = 0
) {
    fun getCommission(transferValue: Int, totalMonthTransfer: Int): Int {
        var commissionAmount = 0
        if (commissionStart > 0 && totalMonthTransfer > commissionStart) {
            commissionAmount = calculateCommission(transferValue)
        } else if (commissionStart == 0) {
            commissionAmount = calculateCommission(transferValue)
        }

        return commissionAmount
    }

    private fun calculateCommission(transferValue: Int): Int {
        var commissionAmount: Int = ((transferValue / 100) * commissionRate).toInt()
        if (commissionAmount < commissionMin) {
            commissionAmount = commissionMin
        }
        commissionAmount += additional
        return commissionAmount
    }
}

object PaymentVK : MoneyTransferRules()

object PaymentMaestroOrMastercard : MoneyTransferRules(
    commissionRate = 0.6,
    additional = 20_00,
    commissionStart = 75_000_00
)

object PaymentVisaOrMir : MoneyTransferRules(
    commissionRate = 0.75,
    commissionMin = 35_00
)
