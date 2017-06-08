package br.uva.findcheap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.uva.findcheap.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_login);
    }

    public void entrarOnClick(View view) {
        String login = ((EditText) findViewById(R.id.editTextLogin)).getText().toString();
        String senha = ((EditText) findViewById(R.id.editTextSenha)).getText().toString();
        if (login.equals("") || senha.equals(""))
            Toast.makeText(getApplicationContext(), "Login e senha devem ser preenchidos!", Toast.LENGTH_SHORT).show();
        else {
            Usuario usuario = new Usuario(login, senha);
            if (MainActivity.setUsuarioLogado(this, usuario)) {
                startActivity(new Intent(this, PrincipalActivity.class));
            } else {
                ((EditText) findViewById(R.id.editTextSenha)).setText("");
                Toast.makeText(getApplicationContext(), "Login ou senha inválidos!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void criarContaOnClick(View view) {
        startActivity(new Intent(this, CriarContaActivity.class));
    }

    public void esqueceuSenhaOnClick(View view) {
        startActivity(new Intent(this, EsqueceuSenhaActivity.class));
    }

}
