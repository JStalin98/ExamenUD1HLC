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


    public void saludar(View v){
        Intent i = new Intent(this, IntroduceDatos.class);
        startActivity(i);
    }

    public void abrirUbicacion(View v){
        Uri localizacion = Uri.parse("geo:36.8514496,-2.465831900000012");
        Intent intent = new Intent(Intent.ACTION_VIEW, localizacion);
       intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void buscarVideo(View v){
        String video = "kXYiU_JCYtU";
        Intent i1 = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + video));
        Intent i2 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + video));
        try {
           startActivity(i1);
        } catch (ActivityNotFoundException ex) {
           startActivity(i2);
        }

    }

}
