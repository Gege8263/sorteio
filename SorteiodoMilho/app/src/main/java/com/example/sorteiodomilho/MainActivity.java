package com.example.sorteiodomilho;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private final TextView resultadoTextView;

    public MainActivity(TextView resultadoTextView) {
        this.resultadoTextView = resultadoTextView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    private void sortearNumeros() {
        List<Integer> numerosSorteados = new ArrayList<>();
        Random random = new Random();

        while (numerosSorteados.size() < 6) {
            int numero = random.nextInt(60) + 1;
            if (!numerosSorteados.contains(numero)) {
                numerosSorteados.add(numero);
            }
        }

        StringBuilder resultado = new StringBuilder();
        for (int numero : numerosSorteados) {
            resultado.append(numero).append(" ");
        }

        resultadoTextView.setText("Números sorteados: " + resultado);
    }
}

