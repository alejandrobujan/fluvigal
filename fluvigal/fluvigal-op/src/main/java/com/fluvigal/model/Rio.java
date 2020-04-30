package com.fluvigal.model;
/**
 * Clase que modela a táboa Rio da base de datos <b>fluvigal_db</b>.
 * 
 * @author Alejandro Buján
 */
public class Rio {
    private int idRio;
    private String nome;
    /**
     * Crea unha instancia dun obxecto {@link com.fluvigal.model.Rio}
     * @param idRio o identificador do río.
     * @param nome o nome do río.
     */
    public Rio(int idRio, String nome) {
        this.idRio = idRio;
        this.nome = nome;
    }
    /**
     * Devolve o identificador da instancia actual.
     * @return o identificador da instancia actual.
     */
    public int getIdRio() {
        return idRio;
    }
    /**
     * Asigna un novo identificador á instancia actual.
     * @param idRio o identificador que se quere asignar.
     */
    public void setIdRio(int idRio) {
        this.idRio = idRio;
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
        return "Rio{" +
                "idRio=" + idRio +
                ", nome=" + nome +
                '}';
    }
}
