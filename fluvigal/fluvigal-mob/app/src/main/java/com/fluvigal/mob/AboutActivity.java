package com.fluvigal.mob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView wv = findViewById(R.id.wv);
        String about_s = "<font size='-1'><p style='text-align: justify'><b>fluvigal</b> (<i>fluvi</i> de <a href='https://academia.gal/dicionario/-/termo/fluvial'>fluvial</a> e <i>gal</i> de <a href='https://gl.wikipedia.org/wiki/Galicia'>Galicia</a>) é unha implementación tanto móbil como web dunha aplicación que facilita e amosa ao público, os datos do estado actual dos ríos galegos (o nivel e caudal da auga), así como o estado actual das estacións na rede de aforos que actualmente están en servizo en Galicia (actualizado cada 10 minutos).</p><p style='text-align: justify'>Unha estación de aforo, é un punto situado no cauce dun río, onde se controla o nivel e caudal que circula por éste. A aplicación encargarase de recopilar estes datos, fundamentais para o correcto seguimento dos episodios de seca e enchente, e de facilitalos a usuarios de todo tipo, xa sexan particulares, empresas ou organizacións non gubernamentais, como información de especial interese ante a situación de cambio climático e quecemento global que sofre o noso planeta.</p><p style='text-align: justify'>O proxecto íntegro e código fonte atópase facendo click <a href='https://gitlab.iessanclemente.net/damo/a16alejandrobp.git'>aquí</a>.</font>";
        wv.loadData(about_s,"text/html", "UTF-8");
    }
}
