package QS_TESTING.blackboxTesting.EqclassTestandBva;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
WeakECTesting -> Cada classe de equival?ncia deve aparecer pelo menos uma vez.
 */
public class WeakECTesting {


    @DisplayName("T1 - str null + maxWidth valido")
    @Test
    void T1_nullString_validMaxWidth_returnsNull() {

        String result = StringUtils.abbreviate(null, 5);

        assertNull(result);
    }

    @DisplayName("T2 - str vazia + maxWidth valido")
    @Test
    void T2_emptyString_validMaxWidth_returnsEmpty() {

        String result = StringUtils.abbreviate("", 5);

        assertEquals("", result);
    }


    @DisplayName("T3 - string cabe no maxWidth")
    @Test
    void T3_stringFitsMaxWidth_returnsOriginalString() {

        String result = StringUtils.abbreviate("abc", 5);

        assertEquals("abc", result);
    }

    @DisplayName("T4 - string longa + maxWidth invalido")
    @Test
    void T4_stringTooLong_invalidMaxWidth_throwsException() {

        assertThrows(
                IllegalArgumentException.class,
                () -> StringUtils.abbreviate("abcdefgh", 3)
        );
    }
}