package com.fluvigal.model;
/**
 * Clase que modela a táboa TipoMedicion da base de datos <b>fluvigal_db</b>.
 * 
 * @author Alejandro Buján
 */
public class TipoMedicion {
    private int idTipo;
    private String nome;
    /**
     * Crea unha instancia dun obxecto {@link com.fluvigal.model.TipoMedicion}
     * @param idTipo o identificador do tipo de medición.
     * @param nome o nome do tipo de medición.
     */
    public TipoMedicion(int idTipo, String nome) {
        this.idTipo = idTipo;
        this.nome = nome;
    }
    /**
     * Devolve o identificador da instancia actual.
     * @return o identificador da instancia actual.
     */
    public int getIdTipo() {
        return idTipo;
    }
    /**
     * Asigna un novo identificador á instancia actual.
     * @param idTipo o identificador que se quere asignar.
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    /**
     * Devolve o nome da instancia actual.
     * @return o nome da instancia actual.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Asigna un novo nome á instancia actual.
     * @param nome o nome que se quere asignar.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Devolve unha representación textual da instancia actual.
     * @return unha representación textual da instancia actual.
     */
    @Override
    public String toString() {
        return "TipoMedicion{" +
                "idTipo=" + idTipo +
                ", tipo='" + nome + '\'' +
                '}';
    }
}
