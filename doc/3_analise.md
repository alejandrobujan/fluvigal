# REQUIRIMENTOS DO SISTEMA
Este documento describe os requirimentos para **fluvigal** especificando que funcionalidade ofrecerá e de que xeito.

## Descrición Xeral

__fluvigal__ (_fluvi_ de [fluvial](https://academia.gal/dicionario/-/termo/fluvial) e _gal_ de [Galicia](https://gl.wikipedia.org/wiki/Galicia)) é unha implementación tanto móbil como web dunha aplicación que facilita e amosa ao público, os datos do estado actual dos ríos galegos (o nivel e caudal da auga), así como o estado actual das estacións na rede de aforos que actualmente están en servizo en Galicia (actualizado cada 10 minutos).

Unha estación de aforo, é un punto situado no cauce dun río, onde se controla o nivel e caudal que circula por éste. A aplicación encargarase de recopilar estes datos, fundamentais para o correcto seguimento dos episodios de seca e enchente, e de facilitalos a usuarios de todo tipo, xa sexan particulares, empresas ou organizacións non gubernamentais, como información de especial interese ante a situación de cambio climático e quecemento global que sofre o noso planeta.

## Funcionalidades

Todas as funcionalidades descritas a continuación son as incluídas nas aplicacións cliente (web e móbil), nas que os únicos actores son usuarios anónimos xa que a aplicación non ten autenticación debido a que ao menos por agora, non é preciso xa que é unha ferramenta de consulta. Estas funcionalidades son:

1. Listar os ríos pertencentes á rede de aforos galega.
2. Listar as estacións pertencentes á rede de aforos galega, podendo filtrar por río.
3. Consultar o estado actual do nivel dos ríos galegos.
4. Consultar o estado actual do caudal dos ríos galegos.
5. Consultar a localización exacta das estacións que realizan estas medicións mediante __Google Maps__.
6. Actualización automática dos datos cada 10 minutos.
 
## Requerimentos non funcionais

Requerimentos relativos a rendemento, seguridade, etc. se procede

## Tipos de usuarios

Tipos de usuario que poderán acceder ó noso sistema, poderán diferenciarse polos permisos sobre os datos, pantallas que se lles mostran, etc.

Exemplo:
  * Usuario xerente, que terá acceso a ...
  * Usuario técnico, que poderá...
 
## Entorno operacional

### Hardware requerido

Indicar elementos hardware que se usarán

### Software

Indicar software que haberá que instalar en cada elemento hardware.

## Interfaces externos

Indicar como se comunicará o noso software co exterior, é posible que só teña interfaces de usuario, que normalmente son as pantallas. Un exemplo de interface hardware sería un lector de código de barras.

### Interfaces de usuario


### Interfaces hardware


### Interfaces software


## Melloras futuras

É posible que o noso proxecto se centre en resolver un problema concreto que se poderá ampliar no futuro con novas funcionalidades, novas interfaces, etc.
