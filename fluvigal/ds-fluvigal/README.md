# ds-fluvigal

__ds-fluvigal__ é o servidor que aloxará tanto a base de datos (fluvigal_db en MariaDB), como a aplicación web (fluvigal-web en Tomcat), ademáis da aplicación fluvigal-pr. Será un container Debian 10, e nun escenario de produción, o despregamento podería estar plantexado para Docker. 

Para facilitar as demostracións, ds-fluvigal aloxarase tamén como unha instancia de Google Cloud con IP estática: 104.198.73.152

## Instalación de MariaDB (fluvigal_db) + SSH

    # Para instalar servidor SSH para acceso remoto + base de datos
    $ apt install openssh-server mariadb-server

    # Traemos script SQL fluvigal_db.sql (dende anfitrión, solicitarase a contrasinal)
    $ scp fluvigal_db.sql alejandro_bujan_pampin@104.198.73.152:/tmp/

    # Comentamos liña 'bind-address' para permitir accesos remotos á base de datos
    $ nano /etc/mysql/mariadb.conf.d/50-server.cnf

    # Accedemos á base de datos (solicitarase a contrasinal)
    $ mysql -u root -p

    # Executamos o script SQL 
    MariaDB [(none)]> source /tmp/fluvigal_db.sql

> Nota: [fluvigal_db.sql](./fluvigal_db.sql) é o arquivo localizado neste mesmo directorio. Neste script podemos visualizar dous tipos de usuarios diferentes, un anónimo `''@'%'` que terá só permiso de consulta `SELECT` e será o que utilizará a librería externa __fluvigal-op__, e o outro, `usuario`, será o que autentique dende __fluvigal-pr__ para actualizar a base de datos. Podese observar unha necesaria gran carga inicial de datos, xa que a base de datos ten unha estrutura fixa, é dicir, só se actualizan as medicións, non se precisa gardar histórico xa que só se proporciona a información do momento da consulta, o resto das táboas gardan sempre os mesmos datos. 

## Instalación de fluvigal-pr + Python + cron

    # Traemos aplicación (dende anfitrión, solicitarase a contrasinal)
    $ scp -rp fluvigal-pr alejandro_bujan_pampin@104.198.73.152:/tmp/

    # Damos permisos de execución (se non os ten) ao script de instalación
    $ chmod +x /tmp/fluvigal-pr/fluvigal-pr-ssh.sh

    # Executamos o script de instalación (solicitarase contrasinal)
    $ /tmp/fluvigal-pr/fluvigal-pr-ssh.sh

> Nota: Localización de fluvigal-pr [aquí](../fluvigal-pr/).

## Instalación Tomcat + app web (fluvigal-web)

    # Instalamos Apache Tomcat
    $ apt install tomcat9

    # Cambiamos o porto 8080 ao 80 en <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
    $ nano /etc/tomcat9/server.xml
    
    # Facemos unha copia de seguridade da Aplicación por defecto (por se acaso)
    $ cp -r /var/lib/tomcat9/webapps/ROOT/ /var/lib/tomcat9/webapps/rootold

    # Limpamos a aplicación raíz
    $ rm -r /var/lib/tomcat9/webapps/ROOT/*

    # Copiamos os novos recursos (dende anfitrión)
    $ scp -rp * alejandro_bujan_pampin@104.198.73.152:/var/lib/tomcat9/webapps/ROOT/

    # Facemos referencia ás librarías dende o classpath
    $ echo "export CLASSPATH=.:/var/lib/tomcat9/webapps/ROOT/WEB-INF/*" >> /etc/profile

    # Reiniciamos o servizo
    $ systemctl restart tomcat9