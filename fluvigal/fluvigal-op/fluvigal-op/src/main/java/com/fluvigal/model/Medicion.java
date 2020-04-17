package com.fluvigal.model;

import java.util.Date;
/**
 * Clase que modela a táboa Medicion da base de datos <b>fluvigal_db</b>.
 * 
 * @author Alejandro Buján
 */
public class Medicion {
    private Estacion estacion;
    private TipoMedicion tipoMedicion;
    private String unidade;
    private double valor;
    private Date data;
    /**
     * Crea unha instancia dun obxecto {@link com.fluvigal.model.Medicion}
     * @param estacion a estación na que se realizan as medicións.
     * @param tipoMedicion o tipo de medición que é.
     * @param unidade a unidade de medida na que está especificada a medición.
     * @param valor o valor obtido ao realizar a medición.
     * @param data a data na que foi realizada a medición.
     */
    public Medicion(Estacion estacion, TipoMedicion tipoMedicion, String unidade, double valor, Date data) {
        this.estacion = estacion;
        this.tipoMedicion = tipoMedicion;
        this.unidade = unidade;
        this.valor = valor;
        this.data = data;
    }
    /**
     * Devolve a estación na que se realizan as medicións.
     * @return a estación na que se realizan as medicións.
     */
    public Estacion getEstacion() {
        return estacion;
    }
    /**
     * Asigna un novo obxecto {@link com.fluvigal.model.Estacion} á medición da instancia actual.
     * @param estacion a estación que se quere asignar.
     */
    public void setEstacion(Estacion estacion) {
        this.estacion = estacion;
    }
    /**
     * Devolve o tipo de medición que é.
     * @return o tipo de medición que é.
     */
    public TipoMedicion getTipoMedicion() {
        return tipoMedicion;
    }
    /**
     * Asigna un novo obxecto {@link com.fluvigal.model.TipoMedicion} á medición da instancia actual.
     * @param tipoMedicion o tipo que se quere asignar.
     */
    public void setTipoMedicion(TipoMedicion tipoMedicion) {
        this.tipoMedicion = tipoMedicion;
    }
    /**
     * Devolve a unidade de medida na que está especificada a medición.
     * @return a unidade de medida na que está especificada a medición.
     */
    public String getUnidade() {
        return unidade;
    }
    /**
     * Asigna unha nova unidade de medida á instancia actual.
     * @param unidade a unidade que se quere asignar.
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    /**
     * Devolve o valor obtido ao realizar a medición.
     * @return o valor obtido ao realizar a medición.
     */
    public double getValor() {
        return valor;
    }
    /**
     * Asigna un novo valor á instancia actual.
     * @param valor o valor que se quere asignar.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    /**
     * Devolve a data na que foi realizada a medición.
     * @return a data na que foi realizada a medición.
     */
    public Date getData() {
        return data;
    }
    /**
     * Asigna un obxecto {@link java.util.Date} á data da instancia actual.
     * Para ter un aspecto máis amigable, pódeselle dar formato co método
     * {@link com.fluvigal.util.Formatter#formatDate}
     * @param data a data que se quere asignar.
     * @see com.fluvigal.util.Formatter#formatDate
     */
    public void setData(Date data) {
        this.data = data;
    }
    /**
     * Devolve unha representación textual da instancia actual.
     * @return unha representación textual da instancia actual.
     */
    @Override
    public String toString() {
        return "Medicion{" +
                "estacion=" + estacion +
                ", tipoMedicion=" + tipoMedicion +
                ", unidade='" + unidade + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
