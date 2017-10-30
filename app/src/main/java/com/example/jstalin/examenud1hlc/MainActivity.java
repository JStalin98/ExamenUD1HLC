package com.example.jstalin.examenud1hlc;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    Metodo que se activara cuando pulsemos el boton saludar
     */
    public void saludar(View v){
        Intent i = new Intent(this, IntroduceDatos.class); // Crea un nuevo intent que abre la Activity IntroduceDatos
        startActivity(i); // Inicia el intent
    }

    /*
    Metodo que se activa cuando pulsemos el boton de Donde estudias
     */
    public void abrirUbicacion(View v){
        Uri localizacion = Uri.parse("geo:36.8514496,-2.465831900000012"); // Objeto que almacenara la ubicacion
        Intent intent = new Intent(Intent.ACTION_VIEW, localizacion); // Creamos un nuevo itene con la ubicacion
       intent.setPackage("com.google.android.apps.maps"); // Indicamos que debe de abrilo con la Aplicacion Maps
        if (intent.resolveActivity(getPackageManager()) != null) { // Comprueba Si da fallo, o la ubicacion no exite
            startActivity(intent); // Inicia el intent
        }
    }

    /*
    Metodo que se activa cuando pulsamos en el boton de buscar video
     */
    public void buscarVideo(View v){
        String video = "kXYiU_JCYtU"; // Alamcenamos el id del video
        Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + video)); // Creamos un itent que nos abrira la plicacion de youtube mas el id
        Intent i2 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + video)); // Creamos un itent que nos abrira el navegador con la direccion de youtube mas el id
        try {
           startActivity(i1);
        } catch (ActivityNotFoundException ex) { // Si al tratar de abrir la aplicacion da fallo, lo intenta abrir desde el navegador
           startActivity(i2);
        }

    }

}
