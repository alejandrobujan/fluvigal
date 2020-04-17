# -*- coding: utf-8 -*-
class Medicion:
    """Clase que modela a táboa Medicion da base de datos fluvigal_db.
    
    Author: Alejandro Buján
    """
    def __init__(self, id_estacion, id_tipo, unidade, valor, data):
        """Crea unha instancia dun obxecto Medicion.
        
        Arguments:
            id_estacion {int} -- O identificador da estación na que se realizan as medicións.
            id_tipo {int} -- O identificador do tipo de medición que é.
            unidade {str} -- A unidade de medida na que está especificada a medición.
            valor {float} -- O valor obtido ao realizar a medición.
            data {datetime} -- A data na que foi realizada a medición.
        """
        self.id_estacion = id_estacion
        self.id_tipo = id_tipo
        self.unidade = unidade
        self.valor = valor
        self.data = data

    @property
    def id_estacion(self):
        """Devolve o identificador da estación na que se realizan as medicións.
        
        Returns:
            int -- O identificador da estación na que se realizan as medicións.
        """
        return self.__id_estacion
    
    @id_estacion.setter
    def id_estacion(self, id_estacion):
        self.__id_estacion = id_estacion

    @property
    def id_tipo(self):
        """Devolve o identificador do tipo de medición que é.
        
        Returns:
            int -- O identificador do tipo de medición que é.
        """
        return self.__id_tipo
    
    @id_tipo.setter
    def id_tipo(self, id_tipo):
        self.__id_tipo = id_tipo

    @property
    def unidade(self):
        """Devolve a unidade de medida na que está especificada a medición.
        
        Returns:
            str -- A unidade de medida na que está especificada a medición.
        """
        return self.__unidade
    
    @unidade.setter
    def unidade(self, unidade):
        self.__unidade = unidade

    @property
    def valor(self):
        """Devolve o valor obtido ao realizar a medición.
        
        Returns:
            float -- O valor obtido ao realizar a medición.
        """
        return self.__valor
    
    @valor.setter
    def valor(self, valor):
        self.__valor = valor

    @property
    def data(self):
        """Devolve a data na que foi realizada a medición.
        
        Returns:
            datetime -- A data na que foi realizada a medición.
        """
        return self.__data
    
    @data.setter
    def data(self, data):
        self.__data = data

    def __str__(self):
        """Devolve unha representación textual da instancia actual.
        
        Returns:
            str -- Unha representación textual da instancia actual.
        """
        return "Medicion[{}:{}:{}:{}:{}]".format(self.id_estacion, self.id_tipo, self.unidade, self.valor, self.data)