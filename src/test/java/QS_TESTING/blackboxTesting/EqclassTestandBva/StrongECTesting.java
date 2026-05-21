package QS_TESTING.blackboxTesting.EqclassTestandBva;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
IMPORTANTE MENCIONAR :

Uma nota importante é que o método verifica se a string é nula ou vazia antes de verificar a largura máxima (maxWidth).

Assim sendo, combinações como:
- abbreviate(null, 3)
não lançam uma exceção IllegalArgumentException, mesmo que maxWidth seja inválido.

Isto acontece porque o método retorna imediatamente a string de entrada antes de chegar à lógica de validação da largura.
 */

public class StrongECTesting {
    // parametro STR -> EC1 = null, EC2 = "", EC3 = str.length() <= maxWidth, EC4 = str.length() > maxWidth
    // parametro MAXWidth -> EC_A = maxWidth < 4 é invalido ; EC_B -> maxWidth >= 4 é valido
    // 8 combinações
    // EC1 + EC_A
    @Test
    void T1_null_invalidMaxWidth() {

        String result = StringUtils.abbreviate(null, 3);

        assertNull(result);
    }

    // EC1 + EC_B
    @Test
    void T2_null_validMaxWidth() {

        String result = StringUtils.abbreviate(null, 5);

        assertNull(result);
    }

    // EC2 + EC_A
    @Test
    void T3_empty_invalidMaxWidth() {

        String result = StringUtils.abbreviate("", 3);

        assertEquals("",result);
    }

    // EC2 + EC_B
    @Test
    void T4_empty_validMaxWidth() {

        String result = StringUtils.abbreviate("", 5);

        assertEquals("", result);
    }

    // EC3 + EC_A
    @Test
    void T5_shortString_invalidMaxWidth() {

        assertThrows(
                IllegalArgumentException.class,
                () -> StringUtils.abbreviate("abc", 3)
        );
    }

    // EC3 + EC_B
    @Test
    void T6_shortString_validMaxWidth() {

        String result = StringUtils.abbreviate("abc", 5);

        assertEquals("abc", result);
    }

    // EC4 + EC_A
    @Test
    void T7_longString_invalidMaxWidth() {

        assertThrows(
                IllegalArgumentException.class,
                () -> StringUtils.abbreviate("abcdefgh", 3)
        );
    }

    // EC4 + EC_B
    @Test
    void T8_longString_validMaxWidth() {

        String result = StringUtils.abbreviate("abcdefgh", 5);

        assertEquals("ab...", result);
    }

}
