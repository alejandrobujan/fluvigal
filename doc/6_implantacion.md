# FASE DE IMPLANTACIÓN

## Manual técnico

### Información relativa á instalación

#### Requirimentos de hardware

Os requerimentos de hardware para cada un dos tipos de equipos que participan no proxecto están detallados na sección "Hardware Requerido" de [Análise](3_analise.md#hardware-requerido).

#### Software necesario

O software necesario para cada un dos tipos de equipos que participan no proxecto están detallados na sección "Software" de [Análise](3_analise.md#software).

#### Configuración inicial seguridade

Regras de devasa:

+ Permitir o tráfico de entrada aos portos 22 (para acceder por SSH), 80 (para a aplicación web) e 3306 (para o acceso remoto a MariaDB).
+ Permitir tamén o tráfico ICMP (para comprobar conectividade). 
+ O acceso por SSH estará limitado en base a claves pública/privada, polo que haberá que transferir a clave pública do equipo de desenvolvemento para acceder.

Engadiuse unha dirección IP pública e estática á instancia.
A información básica reflectida sobre a interface de rede en *Google Cloud Console* é a seguinte:

![Interface de rede](img/6_interface_rede.png)

#### Carga inicial de datos na base de datos

No momento da instalación da base de datos, é preciso realizar unha carga inicial coa información estática, é dicir a información que non se refresca (as estacións que pertencen a cada río, a provincia na que se atopa cada estación, as súas coordenadas...). Esta información obteuse dun xeito híbrido (manual-automático) dende o ficheiro JSON, ao que se lle aplicou un certo formato para derivar nunha estrutura de datos máis eficaz. Esta carga está no ficheiro [fluvigal_db.sql](../fluvigal/ds-fluvigal/fluvigal_db.sql).

#### Usuarios do sistema. Usuarios da aplicación

Nas aplicacións cliente, non existe autenticación ao estar consultando datos públicos, máis no backend, á hora de operar na base de datos, sí é preciso ter certo control en base ao seguintes usuarios, cos correspondentes permisos:

| Usuario | SELECT | CREATE | DROP | INSERT | UPDATE | DELETE | Observacións
|:-       |:-      |:-      |:-    |:-      |:-      |:-      |:-   
| 'usuario'@'localhost' | X | X | X | X | X | X | Encargado de modificar a BD. Uso exclusivo no servidor. 
| ''@'%' | X |  |  |  |  |  | Empregado polos clientes para consultar remotamente os datos e mostralos nas interfaces. É anónimo e non ten contrasinal xa que son datos públicos.

### Información relativa á administración do sistema

Nesta versión do proxecto, as copias de seguridade non son un aspecto crucial, xa que a estrutura da base de datos e a carga inicial atópase nun ficheiro SQL relativamente sinxelo, e os datos dinámicos son actualizados cada 10 minutos, non se garda histórico.

Nun futuro, unha das melloras máis soadas e lóxicas que pode ter o proxecto é a implementación do histórico, como xa se citou no apartado de "Melloras futuras" do [Análise](3_analise.md#melloras-futuras). Nese caso sí sería preciso traballar con copias de seguridade, proceso moi simplificado aproveitando *Google Cloud*, que ofrece a posibilidade de exportar imaxes completas das instancias, así como de realizar snapshots antes de realizar algún cambio importante, estes procesos pódense automatizar. No caso de querer facer copias explícitas da base de datos, poderíamos usar ferramentas como [mysqldump](https://dev.mysql.com/doc/refman/8.0/en/mysqldump.html), ou tamén está a posibilidade de, cun maior orzamento, migrar a base de datos a unha instancia optimizada de Cloud SQL, e aproveitarnos das súas ferramentas de respaldo.

### Información relativa ó mantemento do sistema 

Como en calquera proxecto de software libre, a contribución representa un factor esencial no seu crecemento e mantemento, sendo inviable a súa prosperidade sen colaboradores. As pautas para a contribución están detalladas no ficheiro [CONTRIBUTING](../CONTRIBUTING.md).

Os cambios no proxecto, como as novas funcionalidades ou as correccións de erros serán incorporados ao repositorio oficial mediante o [Mecanismo de Versionado](versionado.md) e reflectidos sempre no [CHANGELOG](../CHANGELOG.md).

## Xestión de incidencias

As incidencias de software máis comúns repórtanse en base ao exposto no ficheiro [CONTRIBUTING](../CONTRIBUTING.md). Para reportar calquera outro tipo de incidencia, sempre e cando non estea contemplada na Guía de Contribución, pódese empregar [este enlace](https://gitlab.iessanclemente.net/damo/a16alejandrobp/issues/new).

Respecto ás incidencias de sistema, o lóxico é que estean reflectidas nos ficheiros log correspondentes do servidor. No caso concreto dos accesos non autorizados á BD, aparecerán no log de error de MariaDB, modificando previamente o nivel de `log_warnings` a 2 no ficheiro de configuración.

## Protección de datos de carácter persoal.

Este software non almacena datos de carácter persoal, polo tanto, neste caso, a [LOPD-GDD](https://es.wikipedia.org/wiki/Ley_Org%C3%A1nica_de_Protecci%C3%B3n_de_Datos_Personales_y_garant%C3%ADa_de_los_derechos_digitales) non é aplicada.

## Manual de usuario

* Indicar se será necesario formar ós usuarios. En caso afirmativo planificar.
* Manual de usuario, FAQ ou outro xeito que sexa o máis adecuado para que os usuarios saiban usar a nosa aplicación informática.
