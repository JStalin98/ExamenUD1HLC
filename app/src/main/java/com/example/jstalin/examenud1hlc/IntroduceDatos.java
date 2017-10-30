package com.example.jstalin.examenud1hlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IntroduceDatos extends AppCompatActivity {
    private final static int CODIGO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_datos);
    }

    public void aceptar(View v) {
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        String stNombre = etNombre.getText().toString();

        Intent intent = new Intent(this, Verifica.class);
        Bundle bundle = new Bundle();
        bundle.putString("NOMBRE", stNombre);
        intent.putExtras(bundle);
        startActivityForResult(intent, CODIGO);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView tvRespuesta = (TextView) findViewById(R.id.tvRespuesta);
        if (requestCode == CODIGO && resultCode == RESULT_OK) {
            String respuesta = data.getExtras().getString("AR");
            tvRespuesta.setText(respuesta);
        }

    }

}