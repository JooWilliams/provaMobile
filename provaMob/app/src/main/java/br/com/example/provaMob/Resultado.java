package br.com.example.provaMob;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    TextView resultado, valorNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        resultado = findViewById(R.id.resultado);
        valorNota = findViewById(R.id.valorNota);

        int nota = getIntent().getIntExtra("nota", -1);

        valorNota.setText("A sua nota foi: " + nota);
    }
}
