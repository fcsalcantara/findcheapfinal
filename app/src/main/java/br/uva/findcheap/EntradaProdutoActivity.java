package br.uva.findcheap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntradaProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_entrada_produto);
    }

    public void homeOnClick(View v) {
        startActivity(new Intent(this, PrincipalActivity.class));
    }

    public void economizarOnClick(View v) {
        startActivity(new Intent(this, SelecionarProdutoActivity.class));
    }
}
