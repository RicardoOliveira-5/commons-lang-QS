package QS_TESTING.blackboxTesting.condition_partition_testing;
/*
ConditionPartitiontesting :
1: Identificar parametros e categorias
2: definir os valores possíveis de cada categoria
3: adicionar restrições
4:  fazer script tsl


funcao utilizada : StringUtils.leftPad -> multiplos parametros independentes e restrições entre elas
 */


/* public static String leftPad(final String str, final int size, final str padChar) */

/*
categoria 1 -> str = null ; str = ""; str < size (n precisa padding); str > size (precisa padding ) ; str = size (nao precisa padding)
categoria 2 -> size = 0 ; <0 ; >0
categoria 3 -> padstr = null ; padstr = '' ; padstr = '1' ; padstr = 'varios chars'

restrições : 1- Se str = null ,  padStr e size são indiferentes (retorna null logo)
             2- size <= str.length() (retorna str logo)
             3- size <= 0 retorna str

 */


/*
tsl generator :
O TSLGenerator não gera todas as combinações possíveis (60), gera o mínimo de testes que garante que cada partição aparece pelo menos uma vez combinada com todas as outras.
É exactamente o objetivo da técnica: 5 × 3 × 4 = 60 testes
z
com condições, gera apenas 18 testes mas nao se consegue observar nada

 */

public class CPT {
}
