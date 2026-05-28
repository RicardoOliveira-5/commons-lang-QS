package QS_TESTING.whiteboxTesting.Data_flowBased_testing;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * White-Box Control Flow Testing ? StringUtils.abbreviate(String str, int maxWidth)
 *
 * Método analisado:
 *   public static String abbreviate(final String str, final int maxWidth)
 *   Localização: org.apache.commons.lang3.StringUtils (commons-lang3)
 *
 * public static String abbreviate(final String str, final int maxWidth) { N1: def(str), def(maxWidth)
 *  *
 *  *       if (isEmpty(str)) {                            N2: p-use(str)
 *  *           return str;                                N3: c-use(str)
 *  *       }
 *  *       if (maxWidth < 4) {                            N4: p-use(maxWidth)
 *  *           throw new IllegalArgumentException(...);   N5: sem use
 *  *       }
 *  *       if (str.length() <= maxWidth) {                N6: p-use(str), p-use(maxWidth)
 *  *           return str;                                N7: c-use(str)
 *  *       }
 *  *       return str.substring(0, maxWidth - 3) + "...";  N8: c-se(str), c-use(maxWidth)
 *  *   }
 *
 */

public class TestBattery {

    //----------------------------------------
    // ALL-DEFS COVERAGE
    //----------------------------------------

    @Test
    void ad01_allDefs_coveredByTruncation() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }
    //basta 1 porque maxWidth é utilizado caso str nao seja null

    @Test
    void ad02_allDefs_strUsedAtN3() {
        assertNull(StringUtils.abbreviate(null, 10));
    }

    //-----------------------------------------
    // ALL-USES COVERAGE
    //-----------------------------------------

    @Test
    void au01_str_use_N2_true() {
        assertNull(StringUtils.abbreviate(null, 10));
    }

    @Test
    void au02_str_use_N3() {
        assertEquals("", StringUtils.abbreviate("", 10));
    }

    @Test
    void au03_str_use_N6_true() {
        assertEquals("hi", StringUtils.abbreviate("hi", 5));
    }

    @Test
    void au04_str_use_N8() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 7));
    }

    @Test
    void au05_maxWidth_use_N4_true() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate("teste", 3));
    }


    //----------------------------------------
    // ALL-DEF-USES COVERAGE
    //----------------------------------------

    @Test
    void du01_str_N1_N2() {
        assertNull(StringUtils.abbreviate(null, 5));           // isEmpty=true
        assertNotNull(StringUtils.abbreviate("algo", 5));     // isEmpty=false
    }

    @Test
    void du02_str_N1_N3() {
        String result = StringUtils.abbreviate("", 10);
        assertEquals("", result);
    }

    @Test
    void du03_str_maxWidth_N1_N6() {
        assertEquals("curta", StringUtils.abbreviate("curta", 10));    // N6 true
        assertEquals("lon...", StringUtils.abbreviate("longuissima", 6)); // N6 false
    }
    //N7 ja é comprovado pois se ser false irá retornar str

    @Test
    void du05_str_maxWidth_N1_N8() {
        assertEquals("Qualida...", StringUtils.abbreviate("Qualidade Software", 10));
    }
    //comprova o uso dos dois

    @Test
    void du06_maxWidth_N1_N4() {
        assertThrows(IllegalArgumentException.class,
                () -> StringUtils.abbreviate("hello", 3));  // N4 true  (3 < 4)
        assertEquals("hel...", StringUtils.abbreviate("hello world", 6)); // N4 false (6 >= 4)
    }

}
