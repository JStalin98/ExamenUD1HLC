package com.example.jstalin.examenud1hlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IntroduceDatos extends AppCompatActivity {
    private final static int CODIGO = 0; // Codigo que sirve para identificarse entre actividades
    EditText etNombre = (EditText) findViewById(R.id.etNombre);
    TextView tvRespuesta = (TextView) findViewById(R.id.tvRespuesta);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_datos);
    }

    /*
    Metodo que se iniciara cuando pulsemos el boton de aceptar
     */
    public void aceptar(View v) {

        String stNombre = etNombre.getText().toString(); // Alamacenamos en una cadena el valor de El campo Edit Text con id etNombre

        Intent intent = new Intent(this, Verifica.class); // Creamos un intene haciendo referencia al la actividad Verifica
        Bundle bundle = new Bundle(); // Nos permitira almacenar informacion
        bundle.putString("NOMBRE", stNombre); // alamacenamos el nombre
        intent.putExtras(bundle); // Le pasamos la informacion al intent
        startActivityForResult(intent, CODIGO); // Iniciaos el intent esperando resutlado

    }

    /*

    Metodo que se activara cuando resibamos resultados
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == CODIGO && resultCode == RESULT_OK) {// Coomprueba que el codigo y el resultado sean correctos
            String respuesta = data.getExtras().getString("AR"); // Almacena la respuesta
            tvRespuesta.setText(respuesta);  // La pone en un text view
        }

    }

    //Guardamos estado

    @Override
    protected void onSaveInstanceState(Bundle guardarEstado) {
        super.onSaveInstanceState(guardarEstado);
       guardarEstado.putString("Nombre", etNombre.getText().toString());
        guardarEstado.putString("Info", tvRespuesta.getText().toString());
    }

    // Recuperamos estado

    @Override
    protected void onRestoreInstanceState(Bundle recEstado) {
        super.onRestoreInstanceState(recEstado);
        etNombre.setText(recEstado.getString("Nombre"));
        tvRespuesta.setText(recEstado.getString("Info"));
    }
}