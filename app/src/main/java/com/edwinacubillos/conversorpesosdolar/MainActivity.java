package com.edwinacubillos.conversorpesosdolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eValor,eResultado;
    Button bConvertir;
    RadioButton rPaD,rDaP;
    int band=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eValor = (EditText) findViewById(R.id.eValor);
        eResultado = (EditText) findViewById(R.id.eResultado);
        bConvertir = (Button) findViewById(R.id.bConvertir);
        rDaP = (RadioButton) findViewById(R.id.rDaP);
        rPaD = (RadioButton) findViewById(R.id.rPaD);

        bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor,resultado=0;
                valor = Double.parseDouble(eValor.getText().toString());

               if(band==0)
                   Toast.makeText(MainActivity.this, "Seleccione conversión",Toast.LENGTH_SHORT).show();
                if (band==1)
                    resultado = valor / 3000;
                if (band==2)
                    resultado = valor * 3000;

                eResultado.setText(String.valueOf(resultado));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rPaD:
                if (checked)
                    band=1;
                    break;
            case R.id.rDaP:
                if (checked)
                    band=2;
                    break;
        }
    }




}
