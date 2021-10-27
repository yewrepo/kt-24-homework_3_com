import org.junit.Assert.*
import org.junit.Test

class MainKtTest {

    @Test
    fun calculateCommissionTest() {
        val v = 1500_00
        val total = 80_000_00
        val totalUnderLimit = 70_000_00

        val vkResult = calculateCommission(v, total)
        val visaResult = calculateCommission(v, total, CardType.VISA)
        val mastercardResult = calculateCommission(v, total, CardType.MASTERCARD)
        val mastercardResultUnderLimit = calculateCommission(v, totalUnderLimit, CardType.MASTERCARD)

        assertEquals(0, vkResult)
        assertEquals(35_00, visaResult)
        assertEquals(29_00, mastercardResult)
        assertEquals(0, mastercardResultUnderLimit)
    }
}