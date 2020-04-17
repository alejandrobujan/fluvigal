package com.fluvigal.util;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
* Clase que almacena os métodos utilizados para
* formatar información de cara a certas cadenas ou saídas.
* 
* @author Alejandro Buján
*/
public class Formatter {
    
    private Formatter() {}
    
    /**
     * Da formato a un obxecto {@link java.util.Date}
     * para que sea lexible e entendible nunha saída.
     * @param date a data á que se quere dar formato.
     * @return a cadea coa data formatada.
     */
    public static String formatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return sdf.format(date);
    }

}