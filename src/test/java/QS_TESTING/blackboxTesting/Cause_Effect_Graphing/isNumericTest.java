package QS_TESTING.blackboxTesting.Cause_Effect_Graphing;
/*
// Comportamento:
StringUtils.isNumeric(null)   // false
StringUtils.isNumeric("")     // false
StringUtils.isNumeric("123")  // true
StringUtils.isNumeric("12 3") // false (espaço)
StringUtils.isNumeric("12.3") // false (ponto)
StringUtils.isNumeric("12a")  // false (letra)
 */

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class isNumericTest {

    @Test
    void T1_isNull_returnsFalse(){
        assertFalse(StringUtils.isNumeric(null));
    }
    @Test
    void T2_empty_returnsFalse() {
        assertFalse(StringUtils.isNumeric(""));
    }
    @Test
    void t3_not_numeric_char_returnsFalse() {
        assertFalse(StringUtils.isNumeric("123a"));
    }

    @Test
    void T3b_hasSpace_returnsFalse() {
        assertFalse(StringUtils.isNumeric("12 3"));
    }

    @Test
    void T3c_hasDecimalPoint_returnsFalse() {
        assertFalse(StringUtils.isNumeric("12.3"));
    }

    @Test
    void T3d_hasNegativeSign_returnsFalse() {
        assertFalse(StringUtils.isNumeric("-123"));
    }

    @Test
    void T4_allNumericChars_returnsTrue() {
        assertTrue(StringUtils.isNumeric("12345"));
    }

    @Test
    void T5_singleNumericChar_returnsTrue() {
        assertTrue(StringUtils.isNumeric("7"));
    }

}
