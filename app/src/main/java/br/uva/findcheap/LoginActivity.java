package br.uva.findcheap;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import br.uva.findcheap.model.Usuario;
import br.uva.findcheap.util.DBHelper;

public class LoginActivity extends AppCompatActivity {
    public final static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static Usuario usuarioLogado;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_login);

        dbHelper = new DBHelper(this);
    }

    public void entrarOnClick(View view) {
        String login = ((EditText) findViewById(R.id.editTextLogin)).getText().toString();
        String senha = ((EditText) findViewById(R.id.editTextSenha)).getText().toString();

        if (login.equals("") || senha.equals(""))
            Toast.makeText(getApplicationContext(), "Login e senha devem ser preenchidos!",
                    Toast.LENGTH_SHORT).show();
        else {
            Usuario u = new Usuario("", login, "", senha);

            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from usuario", null);

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                listaUsuarios.add(
                        new Usuario(
                                cursor.getString(1), cursor.getString(2),
                                cursor.getString(3), cursor.getString(4)) );
                cursor.moveToNext();
            }
            cursor.close();

            if (listaUsuarios.contains(u)) {
                usuarioLogado = listaUsuarios.get(listaUsuarios.indexOf(u));
                startActivity(new Intent(this, PrincipalActivity.class));
            } else {
                ((EditText) findViewById(R.id.editTextSenha)).setText("");
                Toast.makeText(getApplicationContext(), "Login ou senha inválidos!",
                        Toast.LENGTH_SHORT).show();
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
