package br.uva.findcheap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_principal);

        Toast.makeText(getApplicationContext(),
                "Usuário " + LoginActivity.usuarioLogado + " logado",
                Toast.LENGTH_SHORT).show();
    }
}
