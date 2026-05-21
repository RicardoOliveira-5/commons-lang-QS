package QS_TESTING.blackboxTesting.PairWiseTesting;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReplaceTests {
    // funcao replace do Strings.Java
    // 4 parametros :
    // text: null, vazio, matched, not matched
    // searchString: null, vazio, 1 char, mais chars
    // replacement: null, vazia, string normal
    // max : substitiu tudo, nada substitui, substitui N vezes
    // 4*4*3*3 -> 144 , com pairwise -> cerca de 25 testes


    // cobre 24 combinações
    @Test
    void teste1() {
        String result = StringUtils.replace(null, null, null, -1);
        assertNull(result);
    }

    // cobre 24 combinações
    @Test
    void teste2() {
     String res = StringUtils.replace(null, "", "", 0);
     assertNull(res);
    }

    // cobre 24 combinações
    @Test
    void teste3() {
        String res = StringUtils.replace(null, "0", "java", 1);
        assertNull(res);
    }

    // 16 combinações
    @Test
    void teste4() {
        assertNull(StringUtils.replace(null, "world", null, 0));
    }

    // 24 combinações
    @Test
    void teste5() {
        assertEquals("", StringUtils.replace("", null, "java", 0));
    }

    // 20 combinações
    @Test
    void teste6() {
        assertEquals("", StringUtils.replace("", "o", null, -1));
    }

    // 24
    @Test
    void teste7() {
        assertEquals("", StringUtils.replace("", "world", "", 1));
    }

    // 12
    @Test
    void teste8() {
        assertEquals("", StringUtils.replace("", "", "java", 1));
    }

    //20
    @Test
    void teste9() {
        assertEquals("Hello World", StringUtils.replace("Hello World", null, "", 1));
    }

    // 20
    @Test
    void teste10() {

        assertEquals("Hello World", StringUtils.replace("Hello World", "", null, -1));
    }

    // 16
    @Test
    void teste11() {
        // max=0 ? retorna text sem alterações
        assertEquals("Hello World", StringUtils.replace("Hello World", "o", "", 0));
    }

    //20
    @Test
    void teste12() { // errado
        assertEquals("Hello World", StringUtils.replace("Hello World", "WORLD", "java", -1));
    }

    // 12
    @Test
    void teste13() {
        assertEquals("abcdef", StringUtils.replace("abcdef", null, "", 1));
    }

    // 12
    @Test
    void teste14() {
        assertEquals("abcdef", StringUtils.replace("abcdef", "", null, 0));
    }

    // 12
    @Test
    void teste15() {
        assertEquals("abcdef", StringUtils.replace("abcdef", "o", "java", -1));
    }

    // 4
    @Test
    void P16_nomatch_multi_empty_none_caseInsensitive() {
        assertEquals("abcdef", StringUtils.replace("abcdef", "WORLD", "", 0));
    }

    //4
    @Test
    void teste17() {
        assertEquals("Hello World", StringUtils.replace("Hello World", "O", null, 1));
    }

    // 4
    @Test
    void teste18() {
        assertEquals("Hell Wrld", StringUtils.replace("Hello World", "o", "", -1));
    }

    // 4
    @Test
    void P19_match_multi_java_first_caseSensitive() {

        assertEquals("Hello java World", StringUtils.replace("Hello World World", "World", "java", 1));
    }

    // 4
    @Test
    void teste20() {
        assertEquals("Hello World", StringUtils.replace("Hello World", "O", "java", -1));
    }

    // 4
    @Test
    void teste21(){
        assertEquals("abcdef", StringUtils.replace("abcdef", "Z", "", 1));
    }

    // 4
    @Test
    void teste22() {

        assertEquals("Hello World World", StringUtils.replace("Hello World World", "WORLD", "", 1));
    }

    //4
    @Test
    void teste23() {
        assertEquals("Hello World", StringUtils.replace("Hello World", "WORLD", "java", -1));
    }

    //4
    @Test
    void teste24() {
        assertEquals("Hello World", StringUtils.replace("Hello World", "World", null, -1));
    }

    }
