package com.fluvigal.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fluvigal.model.*;
/**
* Clase que almacena os métodos utilizados para
* conectarse e obter datos da base de datos <b>fluvigal_db</b>
* modelizados nos obxectos correspondentes.
* 
* @author Alejandro Buján
*/
public class MariaDBConnector {
    private MariaDBConnector(){}
    private static Connection connection;
    /**
    * Abre unha conexión coa base de datos <b>fluvigal_db</b>,
    * usando credeciais anónimas.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static void openConnection() throws Exception{
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://10.161.55.159/fluvigal_db?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT","","" );
    }
    /**
    * Pecha a conexión coa base de datos <b>fluvigal_db</b>.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static void closeConnection() throws Exception{
        connection.close(); 
    }
    /**
    * Trae da base de datos todas as provincias resxistradas nela.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Provincia} correspondentes.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Provincia> provinciasAsList() throws Exception{
        ArrayList<Provincia> provincias = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Provincia");
        ResultSet data = query.executeQuery();
        while(data.next()){
            provincias.add(new Provincia(data.getInt("idProvincia"), data.getString("nome")));
        }
        return provincias;
    }
    /**
     * Trae da base de datos unha provincia en concreto
     * @param idProvincia o identificador da provincia á que se quere acceder.
     * @return o obxecto {@link com.fluvigal.model.Provincia} correspondente ao identificador.
     * @throws Exception calquera excepción será controlada dende o método principal.
     */
    public static Provincia provinciaQuery(int idProvincia) throws Exception{
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Provincia WHERE idProvincia = ?");
        query.setInt(1, idProvincia);
        ResultSet data = query.executeQuery();
        if(data.next()){
            return (new Provincia(data.getInt("idProvincia"), data.getString("nome")));
        }else{
            return null;
        }
    }
    /**
    * Trae da base de datos todos os ríos resxistrados nela.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Rio} correspondentes.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Rio> riosAsList() throws Exception{
        ArrayList<Rio> rios = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Rio");
        ResultSet data = query.executeQuery();
        while(data.next()){
            rios.add(new Rio(data.getInt("idRio"), data.getString("nome")));
        }
        return rios;
    }
    /**
     * Trae da base de datos un río en concreto
     * @param idRio o identificador do río ao que se quere acceder.
     * @return o obxecto {@link com.fluvigal.model.Rio} correspondente ao identificador.
     * @throws Exception calquera excepción será controlada dende o método principal.
     */
    public static Rio rioQuery(int idRio) throws Exception{
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Rio WHERE idRio = ?");
        query.setInt(1, idRio);
        ResultSet data = query.executeQuery();
        if(data.next()){
            return (new Rio(data.getInt("idRio"), data.getString("nome")));
        }else{
            return null;
        }
    }
    /**
    * Trae da base de datos todas as estacións resxistradas nela.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Estacion} correspondentes.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Estacion> estacionsAsList() throws Exception{
        ArrayList<Estacion> estacions = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Estacion");
        ResultSet data = query.executeQuery();
        while(data.next()){
            estacions.add(new Estacion(data.getInt("idEstacion"), data.getString("nome"), data.getDouble("latitude"), data.getDouble("lonxitude"), data.getString("concello"), rioQuery(data.getInt("idRio")), provinciaQuery(data.getInt("idProvincia"))));
        }
        return estacions;
    }
    /**
    * Trae da base de datos todas as estacións resxistradas relativas a un río en concreto.
    * @param  rio o río que controlan esas estacións.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Estacion} correspondentes
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Estacion> estacionsAsList(Rio rio) throws Exception{
        ArrayList<Estacion> estacions = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Estacion WHERE idRio = ?");
        query.setInt(1, rio.getIdRio());
        ResultSet data = query.executeQuery();
        while(data.next()){
            estacions.add(new Estacion(data.getInt("idEstacion"), data.getString("nome"), data.getDouble("latitude"), data.getDouble("lonxitude"), data.getString("concello"), rioQuery(data.getInt("idRio")), provinciaQuery(data.getInt("idProvincia"))));
        }
        return estacions;
    }
    /**
    * Trae da base de datos todas as estacións resxistradas relativas a unha provincia en concreto.
    * @param  provincia a provincia onde se atopan esas estacións.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Estacion} correspondentes
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Estacion> estacionsAsList(Provincia provincia) throws Exception{
        ArrayList<Estacion> estacions = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Estacion WHERE idProvincia = ?");
        query.setInt(1, provincia.getIdProvincia());
        ResultSet data = query.executeQuery();
        while(data.next()){
            estacions.add(new Estacion(data.getInt("idEstacion"), data.getString("nome"), data.getDouble("latitude"), data.getDouble("lonxitude"), data.getString("concello"), rioQuery(data.getInt("idRio")), provinciaQuery(data.getInt("idProvincia"))));
        }
        return estacions;
    }
    /**
     * Trae da base de datos unha estación en concreto
     * @param idEstacion o identificador da estación á que se quere acceder.
     * @return o obxecto {@link com.fluvigal.model.Estacion} correspondente ao identificador.
     * @throws Exception calquera excepción será controlada dende o método principal.
     */
    public static Estacion estacionQuery(int idEstacion) throws Exception{
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Estacion WHERE idEstacion = ?");
        query.setInt(1, idEstacion);
        ResultSet data = query.executeQuery();
        if(data.next()){
            return (new Estacion(data.getInt("idEstacion"), data.getString("nome"), data.getDouble("latitude"), data.getDouble("lonxitude"), data.getString("concello"), rioQuery(data.getInt("idRio")), provinciaQuery(data.getInt("idProvincia"))));
        }else{
            return null;
        }
    }
    /**
    * Trae da base de datos todas os tipos de medición resxistrados nela.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.TipoMedicion} correspondentes.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<TipoMedicion> tiposMedicionAsList() throws Exception{
        ArrayList<TipoMedicion> tiposMedicion = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM TipoMedicion");
        ResultSet data = query.executeQuery();
        while(data.next()){
            tiposMedicion.add(new TipoMedicion(data.getInt("idTipo"), data.getString("nome")));
        }
        return tiposMedicion;
    }
    /**
     * Trae da base de datos un tipo de medición en concreto
     * @param idTipo o identificador do tipo ao que se quere acceder.
     * @return o obxecto {@link com.fluvigal.model.TipoMedicion} correspondente ao identificador.
     * @throws Exception calquera excepción será controlada dende o método principal.
     */
    public static TipoMedicion tipoMedicionQuery(int idTipo) throws Exception{
        PreparedStatement query = connection.prepareStatement("SELECT * FROM TipoMedicion WHERE idTipo = ?");
        query.setInt(1, idTipo);
        ResultSet data = query.executeQuery();
        if(data.next()){
            return (new TipoMedicion(data.getInt("idTipo"), data.getString("nome")));
        }else{
            return null;
        }
    }
    /**
    * Trae da base de datos todas as medicións realizadas nunha estación en concreto.
    * @param  idEstacion o identificador da estación da que queren obterse as medicións.
    * @return      unha lista cos obxectos {@link com.fluvigal.model.Medicion} correspondentes.
    * @throws java.lang.Exception calquera excepción será controlada dende o método principal.
    */
    public static List<Medicion> medicionsAsList(int idEstacion) throws Exception{
        ArrayList<Medicion> medicions = new ArrayList<>();
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Medicion WHERE idEstacion = ?");
        query.setInt(1, idEstacion);
        ResultSet data = query.executeQuery();
        while(data.next()){
            medicions.add(new Medicion(estacionQuery(data.getInt("idEstacion")),tipoMedicionQuery(data.getInt("idTipo")),data.getString("unidade"),data.getDouble("valor"),data.getDate("data")));
        }
        return medicions;
    }
    /**
     * Trae da base de datos unha medición en concreto
     * @param idEstacion o identificador da estación da que quere obterse a medición.
     * @param idTipo o identificador do tipo do que quere obterse a medición.
     * @return o obxecto {@link com.fluvigal.model.Medicion} correspondente aos identificadores.
     * @throws Exception calquera excepción será controlada dende o método principal.
     */
    public static Medicion medicionQuery(int idEstacion, int idTipo) throws Exception{
        PreparedStatement query = connection.prepareStatement("SELECT * FROM Medicion WHERE idEstacion = ? AND idTipo = ?");
        query.setInt(1, idEstacion);
        query.setInt(2, idTipo);
        ResultSet data = query.executeQuery();
        if(data.next()){
            return (new Medicion(estacionQuery(data.getInt("idEstacion")),tipoMedicionQuery(data.getInt("idTipo")),data.getString("unidade"),data.getDouble("valor"),data.getDate("data")));
        }else{
            return null;
        }
    }
}