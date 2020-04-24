# Mecanismo de versionado

Nun contorno de producción, o deseño das etiquetas basearase no descrito a continuación:

> `vx.y.z-(alpha|beta|rc){N}`

* Onde `x`, é un número que se incrementará, comezando dende o 1, cando se realicen cambios de primeiro nivel ou na estrutura da base de datos.
* Onde `y`, é un número que se incrementará, comezando dende o 0, cando se realicen cambios que se poidan apreciar dende a interface gráfica (aspectos funcionais).
* Onde `z`, é un número que se incrementará, comezando dende o 0, cando se realicen correccións no teu programa ou refactorizacións. (aspectos non funcionais).
* Onde `sufixo`, se é preciso, indicará a fase de desenvolvemento na que se atopa a versión (alpha, beta, rc). A súa ausencia indica unha versión estable.

Exemplo:

    v1.6.3
    v2.0.0-alpha6
    v2.0.0-beta1

## Normas adicionais

+ Utilizaranse caracteres [ASCII](https://es.wikipedia.org/wiki/ASCII) (sen acentos).
+ Á hora de escribir nomes seguirase a convención [lowerCamelCase](https://es.wikipedia.org/wiki/CamelCase).
+ Editarase o ficheiro [changelog.md](../changelog.md) cada vez que se etiquete explicando os cambios.