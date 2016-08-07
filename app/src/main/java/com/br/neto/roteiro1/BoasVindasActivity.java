package com.br.neto.roteiro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BoasVindasActivity extends AppCompatActivity {

    private TextView mBoasVindas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
        Intent intent = getIntent();
        String nome = intent.getExtras().getString("nome");
        String sobrenome = intent.getExtras().getString("sobrenome");

        this.mBoasVindas = (TextView)findViewById(R.id.textBoasVindas);
        this.mBoasVindas.setText("Bem-Vindo " + nome + " " + sobrenome);
    }
}
