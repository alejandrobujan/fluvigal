package com.fluvigal.model;

/**
 * Clase que modela a táboa Provincia da base de datos <b>fluvigal_db</b>.
 * 
 * @author Alejandro Buján
 */
public class Provincia {
    private int idProvincia;
    private String nome;
    /**
     * Crea unha instancia dun obxecto {@link com.fluvigal.model.Provincia}
     * @param idProvincia o identificador da provincia.
     * @param nome o nome da provincia.
     */
    public Provincia(int idProvincia, String nome) {
        this.idProvincia = idProvincia;
        this.nome = nome;
    }
    /**
     * Devolve o identificador da instancia actual.
     * @return o identificador da instancia actual.
     */
    public int getIdProvincia() {
        return idProvincia;
    }
    /**
     * Asigna un novo identificador á instancia actual.
     * @param idProvincia o identificador que se quere asignar.
     */
    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
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
        return "Provincia{" +
                "idProvincia=" + idProvincia +
                ", nome=" + nome +
                '}';
    }
}
