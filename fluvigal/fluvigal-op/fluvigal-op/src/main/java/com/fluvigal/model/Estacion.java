package com.fluvigal.model;
/**
 * Clase que modela a táboa Estacion da base de datos <b>fluvigal_db</b>.
 * 
 * @author Alejandro Buján
 */
public class Estacion {
    private int idEstacion;
    private String nome;
    private double latitude;
    private double lonxitude;
    private String concello;
    private Rio rio;
    private Provincia provincia;
    /**
     * Crea unha instancia dun obxecto {@link com.fluvigal.model.Estacion}
     * @param idEstacion o identificador da estación.
     * @param nome o nome da estación.
     * @param latitude a latitude xeográfica onde se atopa a estación.
     * @param lonxitude a loxitude xeográfica onde se atopa a estación.
     * @param concello o concello onde se atopa a estación.
     * @param rio o río que é controlado pola estación.
     * @param provincia a provincia galega á que pertence a estación.
     */
    public Estacion(int idEstacion, String nome, double latitude, double lonxitude, String concello, Rio rio, Provincia provincia) {
        this.idEstacion = idEstacion;
        this.nome = nome;
        this.latitude = latitude;
        this.lonxitude = lonxitude;
        this.concello = concello;
        this.rio = rio;
        this.provincia = provincia;
    }
    /**
     * Devolve o identificador da instancia actual.
     * @return o identificador da instancia actual.
     */
    public int getIdEstacion() {
        return idEstacion;
    }
    /**
     * Asigna un novo identificador á instancia actual.
     * @param idEstacion o identificador que se quere asignar.
     */
    public void setIdEstacion(int idEstacion) {
        this.idEstacion = idEstacion;
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
     * Devolve a latitude xeográfica onde se atopa a estación.
     * @return a latitude xeográfica onde se atopa a estación.
     */
    public double getLatitude() {
        return latitude;
    }
    /**
     * Asigna un novo valor á latitude da instancia actual.
     * @param latitude o valor de latitude que se quere asignar.
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    /**
     * Devolve a lonxitude xeográfica onde se atopa a estación.
     * @return a lonxitude xeográfica onde se atopa a estación.
     */
    public double getLonxitude() {
        return lonxitude;
    }
    /**
     * Asigna un novo valor á lonxitude da instancia actual.
     * @param lonxitude o valor de lonxitude que se quere asignar.
     */
    public void setLonxitude(double lonxitude) {
        this.lonxitude = lonxitude;
    }
    /**
     * Devolve o concello onde se atopa a estación.
     * @return o concello onde se atopa a estación.
     */
    public String getConcello() {
        return concello;
    }
    /**
     * Asigna un novo valor ao concello da instancia actual.
     * @param concello o valor de concello que se quere asignar.
     */
    public void setConcello(String concello) {
        this.concello = concello;
    }
    /**
     * Devolve o río que é controlado pola estación.
     * @return o río que é controlado pola estación.
     */
    public Rio getRio() {
        return rio;
    }
    /**
     * Asigna un novo obxecto {@link com.fluvigal.model.Rio} ao río da instancia actual.
     * @param rio o río que se quere asignar.
     */
    public void setRio(Rio rio) {
        this.rio = rio;
    }
    /**
     * Devolve a provincia galega á que pertence a estación.
     * @return a provincia galega á que pertence a estación.
     */
    public Provincia getProvincia() {
        return provincia;
    }
    /**
     * Asigna un novo obxecto {@link com.fluvigal.model.Provincia} á provincia da instancia actual.
     * @param provincia a provincia que se quere asignar.
     */
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    /**
     * Devolve unha representación textual da instancia actual.
     * @return unha representación textual da instancia actual.
     */
    @Override
    public String toString() {
        return "Estacion{" +
                "idEstacion=" + idEstacion +
                ", nome='" + nome + '\'' +
                ", latitude=" + latitude +
                ", lonxitude=" + lonxitude +
                ", concello='" + concello + '\'' +
                ", rio=" + rio +
                ", provincia=" + provincia +
                '}';
    }
}
