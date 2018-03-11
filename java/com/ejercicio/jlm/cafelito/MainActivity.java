package com.ejercicio.jlm.cafelito;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    NumberPicker texto;
    TextView cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cantidad = (TextView) findViewById(R.id.Mytext3);
        texto = (NumberPicker) findViewById(R.id.Mytext4);
        texto.setMinValue(0);
        texto.setMaxValue(10);

        texto.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                cantidad.setText("CANTIDAD: " + newVal);
            }
        });
        Button boton = (Button) findViewById(R.id.order);
        boton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                EditText e1 = (EditText) findViewById(R.id.edit1);
                CheckBox uno = (CheckBox) findViewById(R.id.crema);
                CheckBox dos = (CheckBox) findViewById(R.id.chocolate);
                Context contexto = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                if(uno.isChecked() && dos.isChecked()){
                    CharSequence text = "Nombre: " + e1.getText() + "\n" + "Topping: " + uno.getText() +  " y " + dos.getText() + "\n" + "Cantidad: " + texto.getValue() + "Cafes";
                    Toast toast = Toast.makeText(contexto,text,duration);
                    toast.show();
                }else if(uno.isChecked()){
                    CharSequence text = "Nombre: " + e1.getText() + "\n" + "Topping: " + uno.getText() + "\n" + "Cantidad: " + texto.getValue() + "Cafes";
                    Toast toast = Toast.makeText(contexto,text,duration);
                    toast.show();
                }else if(dos.isChecked()){
                    CharSequence text = "Nombre: " + e1.getText() + "\n" + "Topping: " + dos.getText() + "\n" + "Cantidad: " + texto.getValue() + "Cafes";
                    Toast toast = Toast.makeText(contexto,text,duration);
                    toast.show();
                }
            }
        });
    }
}