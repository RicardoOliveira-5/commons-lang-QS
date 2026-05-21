| Condição / Teste        | T1    | T2    | T3    | T4    | T5    |
|-------------------------|-------|-------|-------|-------|-------|
| **C1:** valor `null`    | V     | F     | F     | F     | F     |
| **C2:** string vazia    | ?     | V     | F     | F     | F     |
| **C3:** caractere inválido | -     | -     | V     | F     | F     |
| **C4:** todos numéricos | -     | -     | F     | V     | V     |
|                         |       |       |       |       |       |
| **E1:** resultado `false` | check | check | check |       |       |
| **E2:** resultado `true`  |       |       |       | check | check |