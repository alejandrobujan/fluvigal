# -*- coding: utf-8 -*-
import pymysql
"""Módulo que almacena os métodos utilizados para conectarse e intercambiar datos da base de datos fluvigal_db modelizados nos obxectos correspondentes.

    Author: Alejandro Buján
"""
_conexion = None

def open_connection():
    """Abre unha conexión coa base de datos fluvigal_db.
    """
    global _conexion
    _conexion = pymysql.connect(host="10.161.55.159", 
                           user="usuario", 
                           passwd="abc123.", 
                           database="fluvigal_db")

def update_medicion(medicion):
    """Actualiza a medición enviada como parámetro cos novos datos na base de datos.
    
    Arguments:
        medicion {Medicion} -- A medición que será actualizada na base de datos.
    """
    cursor = _conexion.cursor()
    update_statement = "UPDATE Medicion set unidade = '" + medicion.unidade + "', valor = " + str(medicion.valor) + " , data = '" + str(medicion.data) + "' where idEstacion = " + str(medicion.id_estacion) + " and idTipo = " + str(medicion.id_tipo)
    cursor.execute(update_statement)
    filas = cursor.fetchall()
    _conexion.commit()

def close_connection():
    """Pecha a conexión coa base de datos fluvigal_db.
    """
    global _conexion
    _conexion.close()
