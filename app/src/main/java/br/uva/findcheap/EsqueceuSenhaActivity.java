package br.uva.findcheap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EsqueceuSenhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_esqueceu_senha);
    }
}
