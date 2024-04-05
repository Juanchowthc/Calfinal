package com.example.calculadora20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2, num3, num4;
    private TextView res;
    private Button sumar;

    private Message data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);


        sumar = findViewById(R.id.button);

        data = new Message();

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    double suma = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString());

                    //res.setText(suma+"");
                    showResult(
                            view,
                            num1.getText().toString() + " + " + num2.getText().toString() + " =",
                            suma+"");
                }catch (Exception ex){
                    res.setText("error -> "+ ex.getMessage());
                }
            }
        });

    }

    public void showResult(View view, String information, String result){
        Intent intent = new Intent(this, MainActivity2.class);

        data.setResult(result);
        data.setnformation(information);
        intent.putExtra("data", data );
        startActivity(intent);
    }

    public void restar(View view) {
        try {
            double resta = Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString());
            showResult(view,
                    num1.getText().toString() + " - " + num2.getText().toString() + " =",
                    resta+"");
            //res.setText(resta+"");
        }catch (Exception ex){
            res.setText("error -> "+ ex.getMessage());
        }
    }

    public void multiplicar(View view) {
        try{
            double multi = Double.parseDouble(num1.getText().toString()) * Double.parseDouble(num2.getText().toString());
            //res.setText(multi+"");
            showResult(view,
                    num1.getText().toString() + " X " + num2.getText().toString() + " =",
                    multi+"");
        }catch (Exception ex){
            res.setText("error -> "+ ex.getMessage());
        }
    }
    public void dividir(View view) {
        try{
            double divi = Double.parseDouble(num1.getText().toString()) / Double.parseDouble(num2.getText().toString());
            //res.setText(divi+"");
            showResult(view,
                    num1.getText().toString() + " / " + num2.getText().toString() + " =",
                    divi+"");
        }catch (Exception ex){
            res.setText("error -> "+ ex.getMessage());
        }
    }

    public void factorial(View view) {
        try{
            int numero = Integer.parseInt(num3.getText().toString());
            int resultado = calcularfactorial(numero);
            //res.setText(String.valueOf(resultado));
            showResult(view,
                    "El factorial de " + num3.getText().toString() + " =",
                    String.valueOf(resultado));
        }catch (Exception ex){
            res.setText("error -> "+ ex.getMessage());
        }

    }
    public void calcularPotencia(View view){
        int num = Integer.parseInt(num1.getText().toString());
        int elevacion = Integer.parseInt(num2.getText().toString());

        long resultado = 0;

        try {
            resultado = Potencia.potencia(num,elevacion);

            System.out.println("OK 5^5 => " + resultado);

        } catch (Exception e) {

            System.out.println("exception => " + e.getMessage());
            res.setText(e.getMessage());
            return;
        }

        //res.setText(String.valueOf(resultado));
        showResult(view,
                num1.getText().toString() + " ^ " + num2.getText().toString() + " =",
                String.valueOf(resultado));
    }

    private int calcularfactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calcularfactorial(n - 1);
        }
    }

    public void fibonacci(View view) {

        try{
            int num = Integer.parseInt(num4.getText().toString());
            int resultado = calcularfibonacci(num);
            //res.setText(String.valueOf(resultado));
            showResult(view,
                    "El fibonnaci de " + num4.getText().toString() + " =",
                    String.valueOf(resultado));
        }catch (Exception ex){
            res.setText("error -> "+ ex.getMessage());
        }

    }

    private int calcularfibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcularfibonacci(n - 1) + calcularfibonacci(n - 2);
        }
    }
}
