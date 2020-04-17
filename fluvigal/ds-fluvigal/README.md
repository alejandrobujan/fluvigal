# ds-fluvigal

__ds-fluvigal__ é o servidor que aloxará tanto a base de datos (fluvigal_db en MariaDB), como a aplicación web (fluvigal-web en Tomcat), ademáis da aplicación fluvigal-pr. Será un LXD Container Debian 10, aínda que nun escenario de produción, o despregamento estaría plantexado para Docker. 

Nesta [ligazón](https://drive.google.com/file/d/1WXAOaOe-8UPsp1X6-zec68dObLIT9rNg/view?usp=sharing) atópase a imaxe do container configurada, máis neste documento exporase tamén a configuración que tomou:

## Instalación de MariaDB (fluvigal_db) + SSH

    # Para instalar servidor SSH para acceso remoto + base de datos
    $ apt install openssh-server mariadb-server

    # Para permitir acceso como root dende SSH
    $ echo "PermitRootLogin yes" > /etc/ssh/sshd_config

    # Reiniciamos o servizo SSH
    $ service ssh restart

    # Traemos script SQL fluvigal_db.sql (dende anfitrión, solicitarase a contrasinal)
    $ scp fluvigal_db.sql root@10.161.55.159:/tmp/

    # Comentamos liña 'bind-address' para permitir accesos remotos á base de datos
    $ nano /etc/mysql/mariadb.conf.d/50-server.cnf

    # Accedemos á base de datos (solicitarase a contrasinal)
    $ mysql -u root -p

    # Executamos o script SQL 
    MariaDB [(none)]> source /var/fluvigal_db.sql

> Nota: [fluvigal_db.sql](./fluvigal_db.sql) é o arquivo localizado neste mesmo directorio.

## Instalación de fluvigal-pr + Python + cron

    # Traemos aplicación (dende anfitrión, solicitarase a contrasinal)
    $ scp -rp fluvigal-pr root@10.161.55.159:/tmp/

    # Damos permisos de execución (se non os ten) ao script de instalación
    $ chmod +x /tmp/fluvigal-pr/fluvigal-pr-ssh.sh

    # Executamos o script de instalación (solicitarase contrasinal)
    $ /tmp/fluvigal-pr/fluvigal-pr-ssh.sh

> Nota: Localización de fluvigal-pr [aquí](../fluvigal-pr/).

## Instalación Tomcat + app web (fluvigal-web) (aínda non implementado)