import org.junit.Assert.*
import org.junit.Test
import org.junit.function.ThrowingRunnable

class MainKtTest {

    @Test
    fun calcCommissionVkPayTest() {
        val v = 1500_00
        val total = 80_000_00

        val vkResult = calculateCommission(v, total)

        assertEquals(0, vkResult)
    }

    @Test
    fun calcCommissionVisaOrMir() {
        val v = 1500_00
        val total = 80_000_00

        val visaResult = calculateCommission(v, total, CardType.VISA)
        val mirResult = calculateCommission(v, total, CardType.MIR)

        assertEquals(35_00, visaResult)
        assertEquals(35_00, mirResult)
    }

    @Test
    fun calcCommissionMastercardOrMaestro_noCommission() {
        val v = 1500_00
        val total = 70_000_00

        val mastercardResult = calculateCommission(v, total, CardType.MASTERCARD)
        val maestroResult = calculateCommission(v, total, CardType.MAESTRO)

        assertEquals(0, mastercardResult)
        assertEquals(0, maestroResult)
    }

    @Test
    fun calcCommissionMastercardOrMaestro_shouldGetCommission() {
        val v = 1500_00
        val total = 80_000_00

        val mastercardResult = calculateCommission(v, total, CardType.MASTERCARD)
        val maestroResult = calculateCommission(v, total, CardType.MAESTRO)

        assertEquals(29_00, mastercardResult)
        assertEquals(29_00, maestroResult)
    }

    @Test
    fun printValuesTest() {
        assertThrows(ArithmeticException::class.java) {
            printValues(100, 100 / 0)
        }
    }
}