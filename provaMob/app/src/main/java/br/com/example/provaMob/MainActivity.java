package br.com.example.provaMob;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText resposta1, resposta2, resposta3;
    Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resposta1 = findViewById(R.id.resposta1);
        resposta2 = findViewById(R.id.resposta2);
        resposta3 = findViewById(R.id.resposta3);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r1 = resposta1.getText().toString().trim().toLowerCase();
                String r2 = resposta2.getText().toString().trim().toLowerCase();
                String r3 = resposta3.getText().toString().trim().toLowerCase();


                if (r1.isEmpty() || r2.isEmpty() || r3.isEmpty()){
                    Toast.makeText(MainActivity.this, "Há uma ou mais respostas faltando, preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int acertos = 0;

                if (r1.equals("certo")) acertos++;
                if (r2.equals("certo")) acertos++;
                if (r3.equals("errado")) acertos++;

                int nota;
                if (acertos == 3){
                    nota = 10;
                } else if (acertos == 2) {
                    nota = 6;
                } else if (acertos == 1){
                    nota = 3;
                } else {
                    nota = 0;
                }

                Intent intent = new Intent(MainActivity.this, Resultado.class);
                intent.putExtra("nota", nota);
                startActivity(intent);
            }
        });
    }
}