package com.example.jstalin.examenud1hlc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {
    Bundle bundle; // Para recuperar la informacion del itenet que lo lanzo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);


        bundle = getIntent().getExtras(); // Recuperamos la informacion
        TextView tvInfo2 = (TextView)findViewById(R.id.tvInfo2);
        tvInfo2.setText("Hola " + bundle.getString("NOMBRE") + ". Esto es muy facil, pero date prisa!!");// La añadimos al text view


    }


    /*
    Metodo que se activara al pulsar sobre uno de los dos botones
     */
    public void enviarResultado(View v){

        Intent intent = new Intent(); // Creamos un nuevo itent


        switch (v.getId()) { //Comprobamos que boton ha sifo pulsado
            case R.id.btAcepto:

               intent.putExtra("AR", "Eres muy amable");

                break;
            case R.id.btRechazo:
                intent.putExtra("AR", "Recuerdame que no vuelva a saludarte");

                break;


        }
        setResult(RESULT_OK, intent); // Marcamos que todo ha sido correcto y volvemos a enviar informacion al Activity principal
        finish();//Finalizamos esta actividad

    }
}
