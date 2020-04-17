import json
import requests
from models.Medicion import Medicion
from _datetime import datetime
import string
from connectivity import MariaDBConnector

resp = requests.get('http://servizos.meteogalicia.gal/rss/observacion/jsonAforos.action')
data = json.loads(resp.content)

MariaDBConnector.open_connection()
for aforo in data['listaAforos']:
    p_id_estacion = aforo['ide']
    p_data = datetime.strptime(aforo['dataLocal'].replace("T"," "),'%Y-%m-%d %H:%M:%S')
    for medida in aforo['listaMedidas']:
        m = Medicion(p_id_estacion,medida['codParametro'],medida['unidade'],medida['valor'],p_data)
        MariaDBConnector.update_medicion(m)

MariaDBConnector.close_connection()