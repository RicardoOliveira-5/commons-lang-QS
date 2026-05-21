package QS_TESTING.blackboxTesting.EqclassTestandBva;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BVA_TESTS {

    // maxWidth = 3 (boundary invalid)
    @Test
    void test_maxWidth_below_boundary() {
        assertThrows(IllegalArgumentException.class,
                () -> StringUtils.abbreviate("abcdef", 3));
    }

    // maxWidth = 4 (boundary)
    @Test
    void test_maxWidth_boundary() {
        String result = StringUtils.abbreviate("abcdef", 4);
        assertEquals("a...", result);
    }

    // maxWidth = 5 (just above boundary)
    /*
    IMPORTANTE MENCIONAR: O método não preserva a string original quando o comprimento excede maxWidth.
                              Em vez disso, substitui parte do conteúdo por um marcador de abreviação ("..."),
                              ajustando automaticamente o número de caracteres visíveis.
     */
    @Test
    void test_maxWidth_above_boundary() {
        String result = StringUtils.abbreviate("abcdef", 5);
        assertEquals("abcde", result);
    }

    // str.length = maxWidth
    @Test
    void test_equal_length() {
        String result = StringUtils.abbreviate("abcde", 5);
        assertEquals("abcde", result);
    }

    // str.length > maxWidth
    @Test
    void test_long_string() {
        String result = StringUtils.abbreviate("abcdefg", 5);
        assertEquals("ab...", result);
    }
}
