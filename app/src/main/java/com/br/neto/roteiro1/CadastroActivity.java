package com.br.neto.roteiro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNome, mSobrenome,mUsuario, mSenha1, mSenha2;
    private Button mBtnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        this.mNome = (EditText)findViewById(R.id.nome);
        this.mSobrenome = (EditText)findViewById(R.id.sobrenome);
        this.mUsuario = (EditText)findViewById(R.id.usuario);
        this.mSenha1 = (EditText)findViewById(R.id.senha1);
        this.mSenha2 = (EditText)findViewById(R.id.senha2);
        this.mBtnConfirmar = (Button)findViewById(R.id.btnConfirmar);
        this.mBtnConfirmar.setOnClickListener(clickConfirmar);
    }

    View.OnClickListener clickConfirmar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            cadastrar();
        }
    };

    private void cadastrar(){
        View focus = null;
        if(TextUtils.isEmpty(this.mNome.getText().toString())){
            this.mNome.setError("Campo nome vazio");
            focus = this.mNome;
            focus.requestFocus();
        }else if(TextUtils.isEmpty(this.mSobrenome.getText().toString())){
            this.mSobrenome.setError("Campo sobrenome vazio");
            focus = this.mSobrenome;
            focus.requestFocus();
        }else if(TextUtils.isEmpty(this.mUsuario.getText().toString())){
            this.mUsuario.setError("Campo usuario vazio");
            focus = this.mUsuario;
            focus.requestFocus();
        }else if(TextUtils.isEmpty(this.mSenha1.getText().toString())){
            this.mSenha1.setError("Campo senha vazio");
            focus = this.mSenha1;
            focus.requestFocus();
        }else if(TextUtils.isEmpty(this.mSenha2.getText().toString())){
            this.mSenha2.setError("Campo confirma senha vazio");
            focus = this.mSenha2;
            focus.requestFocus();
        }else if(!this.mSenha1.getText().toString().equalsIgnoreCase(this.mSenha2.getText().toString())){
            this.mSenha2.setError("Senhas não conferem!");
            focus = this.mSenha2;
            focus.requestFocus();
        }else{
            Intent intent = new Intent(this, BoasVindasActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("nome", this.mNome.getText().toString());
            bundle.putString("sobrenome",this.mSobrenome.getText().toString());
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }
}
