# REQUIRIMENTOS DO SISTEMA
Este documento describe os requirimentos para **fluvigal** especificando que funcionalidade ofrecerá e de que xeito.

## Descrición Xeral

__fluvigal__ é unha implementación tanto móbil como web dunha aplicación que facilita e amosa ao público, os datos do estado actual dos ríos galegos (o nivel e caudal da auga), así como o estado actual das estacións na rede de aforos que actualmente están en servizo en Galicia (actualizado cada 10 minutos).

Unha estación de aforo, é un punto situado no cauce dun río, onde se controla o nivel e caudal que circula por éste. A aplicación encargarase de recopilar estes datos, fundamentais para o correcto seguimento dos episodios de seca e enchente, e de facilitalos a usuarios de todo tipo, xa sexan particulares, empresas ou organizacións non gubernamentais, como información de especial interese ante a situación de cambio climático e quecemento global que sofre o noso planeta.

## Funcionalidades

Todas as funcionalidades descritas a continuación son as incluídas nas aplicacións cliente (web e móbil), nas que os únicos actores son usuarios anónimos xa que a aplicación non ten autenticación debido a que ao menos por agora, non é preciso xa que é unha ferramenta de consulta de datos públicos. Estas funcionalidades son:

1. Listar os ríos pertencentes á rede de aforos galega.
2. Listar as estacións pertencentes á rede de aforos galega, podendo filtrar por río.
3. Consultar o estado actual do nivel dos ríos galegos.
4. Consultar o estado actual do caudal dos ríos galegos.
5. Consultar a localización exacta das estacións que realizan estas medicións mediante __Google Maps__.
6. Actualización automática dos datos cada 10 minutos.
 
## Requerimentos non funcionais

Requerimentos relativos a rendemento, seguridade, etc. se procede

## Tipos de usuarios

Como é comentado no apartado de [Funcionalidades](#Funcionalidades), nas aplicacións cliente non existe autenticación, máis no backend, á hora de operar na base de datos, sí é preciso ter certo control en base ao seguintes usuarios, cos correspondentes permisos:

| Usuario | SELECT | CREATE | DROP | INSERT | UPDATE | DELETE | Observacións
|:-       |:-      |:-      |:-    |:-      |:-      |:-      |:-   
| 'usuario'@'localhost' | X | X | X | X | X | X | Encargado de modificar a BD. Uso exclusivo no servidor. 
| ''@'%' | X |  |  |  |  |  | Empregado polos clientes para consultar remotamente os datos e mostralos nas interfaces. É anónimo e non ten contrasinal xa que son datos públicos.
 
## Contorno operacional

> **IMPORTANTE**: En todo o contorno é precisa unha conexión a internet para un correcto funcionamento.

### Hardware requerido

***

#### Servidor

O servidor é unha instancia en Google Cloud de tipo *n1-standard-1*:

| Tipo              | Requerido
|:-                 |:-
| CPU               | **1 vCPU**
| Plataforma de CPU | **Intel Haswell**
| Memoria RAM       | **3,75 GB**
| Zona              | **us-central1-a**
| Disco             | **10GB HDD**

#### Clientes

Os dispositivos que empreguen a aplicación cliente web precisarán cumprir os requerimentos esixidos polos navegadores máis comúns, xa que se executará sobre eles. Aquí está o exemplo de [Firefox](https://support.mozilla.org/en-US/kb/supported-platforms-and-system-requirements).

Os terminais móbiles que instalarán a aplicación cliente móbil precisarán cumprir os requerimentos esixidos por **Android Nougat**: 
+ Arquitectura ARM v5 ou maior
+ 512MB de Memoria RAM
+ 8GB de Almacenamento Interno

#### Equipos de desenvolvemento

Nos equipos de desenvolvemento, os requerimentos hardware serían os precisos para traballar cómodamente con IDEs como [Android Studio](https://es.wikipedia.org/wiki/Android_Studio#Plataformas) ou [Visual Studio Code](https://code.visualstudio.com/docs/supporting/requirements).

### Software

***

#### Servidor

No servidor [ds-fluvigal](../fluvigal/ds-fluvigal) instalarase de base o sistema operativo **Debian 10** cos servizos *MariaDB* e *Apache Tomcat* (no que se executará [fluvigal-web](../fluvigal/fluvigal-web)), ademáis de [fluvigal-pr](../fluvigal/fluvigal-pr).

#### Clientes

Para os clientes web o sistema operativo é de libre elección e esa é a principal vantaxe do seu desenvolvemento. Bastaría con poder instalara un navegador web como *Mozila Firefox*, *Google Chrome*, *Microsoft Edge*, *Opera* ou *Safari*.

Para os clientes móbiles precisarase como mínimo Android Nougat (7.0) e nel instalar a implementación [fluvigal-mob](../fluvigal/fluvigal-mob).

#### Equipos de desenvolvemento

Para os equipos de desenvolvemento, o sistema operativo deberá estar marcado polas posibilidades que ofrezan os requerimentos de *Android Studio* e *Visual Studio Code*, que son os IDEs empregados para o seu desenvolvemento.

## Interfaces externos

Indicar como se comunicará o noso software co exterior, é posible que só teña interfaces de usuario, que normalmente son as pantallas. Un exemplo de interface hardware sería un lector de código de barras.

### Interfaces de usuario


### Interfaces hardware


### Interfaces software


## Melloras futuras

É posible que o noso proxecto se centre en resolver un problema concreto que se poderá ampliar no futuro con novas funcionalidades, novas interfaces, etc.
