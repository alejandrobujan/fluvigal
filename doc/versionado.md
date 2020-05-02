# Mecanismo de versionado

Nun contorno de producción, o deseño das etiquetas basearase no descrito a continuación:

> `vx.y.z-(alpha|beta|rc){N}`

| Monema | Significado |
| ------ | ------ |
| `x` | É un número que se incrementará, comezando dende o 1, cando se realicen cambios de primeiro nivel ou na estrutura da base de datos. |
| `y` | É un número que se incrementará, comezando dende o 0, cando se realicen cambios que se poidan apreciar dende a interface gráfica (aspectos funcionais). | 
| `z` | É un número que se incrementará, comezando dende o 0, cando se realicen correccións teu programa ou refactorizacións. (aspectos non funcionais). |
| `(sufixo)` | Se é preciso, indicará a fase de desenvolvemento na que se atopa a versión (alpha, beta, rc). A súa ausencia indica unha versión estable. | 

Algúns exemplos:

    v1.6.3
    v2.0.0-alpha6
    v2.0.0-beta1

## Información sobre sufixos

| Sufixo | Significado |
| ------ | ------ |
| `alpha` | As primeiras versións en saír, e polo tanto as máis inestables. É probable que existan problemas importantes de seguridade. |
| `beta` | Saen cando se resolven todos os erros críticos, de seguridad e pérdida de datos. As características de usabilidade aínda se consideran. | 
| `rc` | Son creadas cando non se informou de máis erros críticos nunha versión beta dada. Considéranse código case estable e candidato para ser lanzado como a versión oficial. | 

## Normas adicionais

+ Utilizaranse caracteres [ASCII](https://es.wikipedia.org/wiki/ASCII) (sen acentos).
+ Á hora de escribir nomes seguirase a convención [lowerCamelCase](https://es.wikipedia.org/wiki/CamelCase).
+ Editarase o ficheiro [changelog.md](../changelog.md) cada vez que se etiquete explicando os cambios.