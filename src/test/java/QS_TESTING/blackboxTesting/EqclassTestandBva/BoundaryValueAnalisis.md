# Análise de Valores Limite (Boundary Value Analysis - BVA)

A Análise de Valores Limite é uma técnica de testes de caixa-preta baseada no princípio de que erros ocorrem com maior frequência nos limites das entradas do que em valores intermédios. Esta técnica foca-se nos valores de fronteira: imediatamente abaixo, no limite e imediatamente acima.

## 1. O Método Analisado

`StringUtils.abbreviate(String str, int maxWidth)`

Os parâmetros relevantes para a análise são:
* **str**: O tamanho da string (`str.length()`).
* **maxWidth**: A largura máxima permitida para o resultado.

---

## 2. Identificação dos Valores Limite

### 2.1 Limite de `maxWidth`
De acordo com a implementação, o `maxWidth` deve ser no mínimo 4 (para acomodar o conteúdo e as reticências "...").

* **Valor Crítico:** 4
* **Valores Analisados:**
    * **3**: Abaixo do limite (Inválido)
    * **4**: No limite (Válido)
    * **5**: Acima do limite (Válido)

### 2.2 Limite de `str.length()`
A lógica de abreviação depende da comparação entre o tamanho da string e o `maxWidth`.

* **str.length() <= maxWidth**: Não ocorre abreviação.
* **str.length() > maxWidth**: Ocorre abreviação.
* **Pontos de teste sugeridos:** `maxWidth - 1`, `maxWidth`, `maxWidth + 1`.

---

## 3. Níveis de Rigor da Análise

### 3.1 Boundary Value Analysis (BVA) Simples
Considera 5 valores para cada variável: Mínimo, Mínimo + 1, Nominal, Máximo - 1 e Máximo.
* **Fórmula:** 4n + 1 (onde *n* é o número de variáveis)
* **Cálculo (2 variáveis):** 4(2) + 1 = **9 casos de teste**.

### 3.2 Boundary Value Analysis Robusta
Adiciona valores inválidos imediatamente fora dos limites (Mínimo - 1 e Máximo + 1).
* **Fórmula:** 6n + 1
* **Cálculo (2 variáveis):** 6(2) + 1 = **13 casos de teste**.

### 3.3 Worst Case Boundary Value Analysis
Testa todas as combinações possíveis dos 5 valores limite de cada variável.
* **Fórmula:** 5^n
* **Cálculo (2 variáveis):** 5² = **25 casos de teste**.

### 3.4 Worst Case Robusta
Inclui valores inválidos em todas as combinações possíveis, resultando em 7 valores por variável.
* **Fórmula:** 7^n
* **Cálculo (2 variáveis):** 7² = **49 casos de teste**.

---

## 4. Conclusão e Resumo

A aplicação desta técnica permite focar em situações críticas onde a probabilidade de falha é maior. À medida que a técnica se torna mais rigorosa, a cobertura e a confiança na correção do sistema aumentam significativamente.

| Técnica | Fórmula | Nº de Casos de Teste |
| :--- | :--- | :--- |
| **BVA Simples** | 4n + 1 | 9 |
| **BVA Robusta** | 6n + 1 | 13 |
| **Worst Case** | 5^n | 25 |
| **Worst Case Robusta** | 7^n | 49 |