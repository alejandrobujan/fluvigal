#!/bin/bash

if [[ $EUID -ne 0 ]]; then
   echo "This script must be run as root" 
   exit 1
fi

cd "$(dirname "$0")"

cp -r fluvigal-pr /var/

apt install cron python3 python3-pip

pip3 install requests

pip3 install pymysql

line="*/10 * * * * /usr/bin/python3 /var/fluvigal-pr/main.py"
(crontab -u root -l; echo "$line" ) | crontab -u root -