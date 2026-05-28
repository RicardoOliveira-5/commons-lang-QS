package QS_TESTING.whiteboxTesting.TestsBattery;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * White-Box Control Flow Testing ? StringUtils.abbreviate(String str, int maxWidth)
 *
 * Método analisado:
 *   public static String abbreviate(final String str, final int maxWidth)
 *   Localização: org.apache.commons.lang3.StringUtils (commons-lang3)
 *
 * O diagrama de fluxo de controlo contêm:
 *
 *  Nós (N): 8
 *  Arestas (E): 11
 *  Nós de Decisão (P): 3
 *  Complexidade Ciclomática (V(G)): E - N + 2 = 11 - 9 + 2 = 4
 *
 *  Conjunto de Caminhos Independentes:
 *    1. str == null
 *    2. maxWidth < 4
 *    3. str.length() <= maxWidth
 *    4. str.length() > maxWidth && maxWidth >= 4
 *
 *
 */
public class TestBattery {

    //----------------------------------------
    // STATEMENT / NODE COVERAGE
    //----------------------------------------

    @Test
    void S1_strIsNull_returnsNull() {
        assertNull(StringUtils.abbreviate(null, 10));
    }

    @Test
    void S1_strIsEmpty_returnsEmpty() {
        assertEquals("", StringUtils.abbreviate("", 10));
    }

    @Test
    void S2_maxWidthLessThan4_throwsIAE() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("Qualidade Software", 3));
    }

    @Test
    void S3_strLengthLessThanOrEqualMaxWidth_returnsOriginalString() {
        assertEquals("Teste", StringUtils.abbreviate("Teste", 5));
    }

    @Test
    void S4_strLengthGreaterThanMaxWidth_returnsAbbreviatedString() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }

    //----------------------------------------
    // CONDITION COVERAGE
    //----------------------------------------

    @Test
    void C1_True_returnsNull() {
        assertNull(StringUtils.abbreviate(null, 10));
    }

    @Test
    void C2_False_True_ThrowIAE() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("Qualidade Software", 3));
    }

    @Test
    void C3_False_False_True_ReturnOriginal() {
        assertEquals("Teste", StringUtils.abbreviate("Teste", 5));
    }

    @Test
    void C4_False_False_False_ReturnAbbreviated() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }

    //----------------------------------------
    // DECISION COVERAGE
    //----------------------------------------

    @Test
    void dc01_d1True() {
        assertNull(StringUtils.abbreviate(null, 8));
    }

    @Test
    void dc02_d2True() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("Qualidade Software", 3));
    }

    @Test
    void dc03_d3True() {
        assertEquals("Teste", StringUtils.abbreviate("Teste", 5));
    }

    @Test
    void dc04_d3False() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }

    //----------------------------------------
    // MODIFIED CONDITION / DECISION COVERAGE  (MC/DC)
    //----------------------------------------

    @Test
    void mcdc01_isEmptyChanges() {
        assertEquals("abcde", StringUtils.abbreviate("abcde", 10));
        assertNull(StringUtils.abbreviate(null, 10));
    }

    @Test
    void mscd02_maxWidthChanges() {
        assertEquals("a...", StringUtils.abbreviate("abcdef", 4));
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("abcdef", 3));
    }

    @Test
    void mscd03_lengthVsMaxWidthChanges() {
        assertEquals("abc", StringUtils.abbreviate("abc", 4));
        assertEquals("ab...", StringUtils.abbreviate("abcdef", 5));
    }

    //----------------------------------------
    // INDEPENDENT PATH COVERAGE
    //----------------------------------------

    @Test
    void ipc_p1_nullStr() {
        assertNull(StringUtils.abbreviate(null, 6));
    }

    @Test
    void ipc_p1b_emptyStr() {
        assertEquals("", StringUtils.abbreviate("", 6));
    }

    @Test
    void ipc_p2_illegalWidth() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("abcdef", 3));
    }

    @Test
    void ipc_p3a_strShorterThanMax() {
        assertEquals("Go", StringUtils.abbreviate("Go", 10));
    }

    @Test
    void ipc_p3b_strExactlyMaxWidth() {
        assertEquals("abcd", StringUtils.abbreviate("abcd", 4));
    }

    @Test
    void ipc_p4a_truncateMinWidth() {
        assertEquals("a...", StringUtils.abbreviate("abcde", 4));
    }

    @Test
    void ipc_p4b_truncateLongString() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }
}
