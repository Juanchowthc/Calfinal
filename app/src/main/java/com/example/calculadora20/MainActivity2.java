package com.example.calculadora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView textViewInformation;
    private TextView textViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewInformation = findViewById(R.id.textInformation);
        textViewResult = findViewById(R.id.textResult);

        Intent intent = getIntent();

        Message data = (Message)intent.getSerializableExtra("data");

        textViewInformation.setText(data.getInformation());
        textViewResult.setText(data.getResult());

        if(data.getInformation().length() > 10){
            textViewInformation.setTextSize(TypedValue.COMPLEX_UNIT_PX,45);
            textViewResult.setTextSize(TypedValue.COMPLEX_UNIT_PX,45);
        }
    }

    public void volver_pantalla(View view){
        /*Intent c = new Intent(this, MainActivity.class);
        startActivity(c);*/
        finish();
    }
}