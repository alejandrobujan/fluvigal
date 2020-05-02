# fluvigal

<img src="doc/img/0_logo.png" width="150" height="150"/>

## Descrición

__fluvigal__ (_fluvi_ de [fluvial](https://academia.gal/dicionario/-/termo/fluvial) e _gal_ de [Galicia](https://gl.wikipedia.org/wiki/Galicia)) é unha implementación tanto móbil como web dunha aplicación que facilita e amosa ao público, os datos do estado actual dos ríos galegos (o nivel e caudal da auga), así como o estado actual das estacións na rede de aforos que actualmente están en servizo en Galicia (actualizado cada 10 minutos).

Unha estación de aforo, é un punto situado no cauce dun río, onde se controla o nivel e caudal que circula por éste. A aplicación encargarase de recopilar estes datos, fundamentais para o correcto seguimento dos episodios de seca e enchente, e de facilitalos a usuarios de todo tipo, xa sexan particulares, empresas ou organizacións non gubernamentais, como información de especial interese ante a situación de cambio climático e quecemento global que sofre o noso planeta.

## Instalación / Posta en marcha

Para obter o repositorio en local, é preciso empregar a ferramenta de terminal `git`:

    git clone https://gitlab.iessanclemente.net/damo/a16alejandrobp.git

### Produto final

O produto final, como foi indicado anteriormente, consta dunha implementación web e outra móbil `Android`, polo cal, lóxicamente serán accesibles de dúas formas diferentes.

#### Aplicación web (fluvigal-web)

Para acceder á webapp para probala, será tan sinxelo como seguir esta [ligazón](http://104.198.73.152). No caso de que o navegador non soporte hipervínculos, será preciso pegar a seguinte liña na barra de direccións:

    http://104.198.73.152

O código fonte está accesible dende [fluvigal/fluvigal-web](fluvigal/fluvigal-web).

#### Aplicación móbil (fluvigal-mob)

A versión da aplicación para dispositivos móbiles é compatible con terminais `Android` coa versión 7.0 (API 24) como mínimo. Para probala dende un computador será preciso un emulador de `Android` coa mesma versión mínima que a indicada anteriormente. 

O ficheiro APK está atópase ubicado [aquí](https://drive.google.com/file/d/1i5h8uwO-dEwRAa7lrH5RvBenhQP2AnRA/view?usp=sharing). O código fonte está accesible dende [fluvigal/fluvigal-mob](fluvigal/fluvigal-mob).

> **Nota**: A aplicación foi probada con éxito nun dispositivo físico **Xiaomi Mi A1** (7.0) e nun emulador **Pixel** (9.0).

### Contorno e infraestrutura (Avanzado)

Para o desenvolvemento de ambas aplicacións, empregouse a API __fluvigal-op__, encargada das interaccións coa base de datos, para empregala en novos proxectos haberá que importar a librería [JAR](fluvigal/fluvigal-op).

A posta en marcha da infraestrutura baséase na configuración de __ds-fluvigal__, a instancia `GCloud` de `Debian 10` que actúa como servidor encargado de procesar e almacenar os datos da rede de aforos. As instruccións da configuración atópanse [aquí](fluvigal/ds-fluvigal). A instancia aloxa tamén os seguintes servizos:

#### Base de datos MariaDB (fluvigal_db)

Será necesaria unha carga inicial de modelado e rexistros na base de datos, o script está ubicado [aquí](fluvigal/ds-fluvigal/fluvigal_db.sql). 

#### Aplicación backend Python (fluvigal-pr)

Engargada das peticións externas, do seu procesamento e da actualización continua da base de datos. O script de instalación atópase [aquí](fluvigal/fluvigal-pr/fluvigal-pr-setup.sh).

## Uso

Tanto as interfaces web como móbil son moi intuitivas e permiten unha experiencia de usuario sen complicacións, permitindo:

+ Listar os ríos pertencentes á rede de aforos galega.
+ Listar as estacións pertencentes á rede de aforos galega, podendo filtrar por río.
+ Consultar o estado actual do nivel dos ríos galegos.
+ Consultar o estado actual do caudal dos ríos galegos.
+ Consultar a localización exacta das estacións que realizan estas medicións mediante __Google Maps__.
+ Actualización automática dos datos cada 10 minutos.

## Sobre o autor

Chámome __Alejandro Buján Pampín__, e en términos xerais son un apaixonado da informática. Dende os comezos da miña vida (xeración do 2000) estiven en contacto coas novas tecnoloxías e isto derivou nunha relación amor-odio que rematou nomalizándose ata volverse parte de min.

Actualmente estou a punto de titular como técnico superior en __Desenvolvemento de Aplicacións Multiplataforma__ e son técnico en __Sistemas Microinformáticos e Redes__. Tamén acadei recoñocementos como as Medallas de Bronce (Nacional) e Ouro (Autonómico) nas olimpiadas de Formación Profesional 2018-19 na disciplina de __Administración de Sistemas en Rede__ e fixen prácticas en cidades estranxeiras como Lisboa ou Turín. Unha traxectoria que me gustaría continuar con estudos universitarios de grao en __Enxeñaría Informática__.

Estou familiarizado con tecnoloxías como:  
+ Administración de SO: GNU/Linux e Windows (Desktop e Server)
+ Cloud: AWS, Azure, GCloud
+ Redes, firewalls, seguridade informática.
+ Programación: Java, Python, C#, Visual Basic .NET
+ SXBD: MySQL/MariaDB, Microsoft SQL Server, PostgreSQL, MongoDB, Oracle.

Decanteime por __fluvigal__ pola ausencia de alternativas accesibles para a consulta dunha información, na miña opinión, de primeiro nivel, así como do reto que supoñía para min, o feito de desenvolver unha aplicación web, e o aprendizaxe no uso de tecnoloxías como GCloud ou ReactiveX.

__e-mail__: <alejandro.bujan.pampin@gmail.com>  
__móbil__: [+34 617 238 186](tel:+34617238186)  
__LinkedIn__: <https://www.linkedin.com/in/alejandro-bujan-pampin/>


## Licenza

Non podendo ser doutra forma, este proxecto é completamente **software libre**, nacido por e para a comunidade baixo as condicións da Licenza Xeral Pública GNU v3 da [Free Software Foundation](https://www.fsf.org/es) e mantendo sempre o recoñecemento á autoría e contribucións. 

Os termos están descritos e detallados no ficheiro [LICENSE.md](LICENSE.md).

## Índice

1. [Idea](doc/1_idea.md) 
2. [Necesidades](doc/templates/2_necesidades.md) (Por facer)
3. [Análise](doc/templates/3_analise.md) (Por facer)
4. [Deseño](doc/4_deseno.md) (Incompleto)
5. [Planificación](doc/templates/5_planificacion.md) (Por facer)
6. [Implantación](doc/templates/6_implantacion.md) (Por facer)
7. [Software](fluvigal/)  
    7.1 [ds-fluvigal](fluvigal/ds-fluvigal/)  
    7.2 [fluvigal-pr](fluvigal/fluvigal-pr/)  
    7.3 [fluvigal-op](fluvigal/fluvigal-op/)  
    7.4 [fluvigal-web](fluvigal/fluvigal-web/)  
    7.5 [fluvigal-mob](fluvigal/fluvigal-mob/)    
8. [Mecanismo de versionado](doc/versionado.md)
9. [Changelog](CHANGELOG.md)

## Guía de contribución

Este proxecto admite contribucións tanto de usuarios cotiás como de programadores, agradécese calquera tipo de colaboración que axude a __fluvigal__ a medrar. As pautas a seguir están redactadas no ficheiro [CONTRIBUTING](CONTRIBUTING.md).

## Links

| Descrición                          | URL
|:-                                   |:-
| Repositorio do proxecto fluvigal    | https://gitlab.iessanclemente.net/damo/a16alejandrobp
| Datos abertos da Xunta de Galicia   | https://abertos.xunta.gal/
| Debian                              | https://www.debian.org/
| GCloud                              | https://cloud.google.com/
| MariaDB                             | https://mariadb.org/
| Java                                | https://www.java.com/es/
| Python                              | https://www.python.org/
| Android Developers                  | https://developer.android.com/
| Apache Tomcat                       | http://tomcat.apache.org/
| Apache Maven                        | http://maven.apache.org/
| ReactiveX                           | http://reactivex.io/
| Free Software Foundation            | https://www.fsf.org/es

***

Deseño da __base__ do logo atribuído a [Vecteezy](https://www.vecteezy.com/vector-art/595494-wave-water-logo-beach-vector).
