package br.uva.findcheap;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import br.uva.findcheap.model.Usuario;
import br.uva.findcheap.util.DBHelper;

public class MainActivity extends AppCompatActivity {

    private static Usuario usuarioLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        usuarioLogado = null;
        startActivity(new Intent(this, LoginActivity.class));
    }

    private static ArrayList<Usuario> getListaUsuarios(Context context) {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        if (context.getClass() == LoginActivity.class) {
            Usuario usuario;
            DBHelper dbHelper = new DBHelper(context);
            Cursor cursor = dbHelper.getReadableDatabase().rawQuery("select * from usuario", null);
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                usuario = new Usuario();
                usuario.setNome( cursor.getString(1) );
                usuario.setEmail( cursor.getString(2) );
                usuario.setCpf( cursor.getString(3) );
                usuario.setSenha( cursor.getString(4) );
                listaUsuarios.add(usuario);
                cursor.moveToNext();
            }
            cursor.close();
            dbHelper.close();
            return listaUsuarios;
        } else {
            return null;
        }
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static boolean setUsuarioLogado(Context context, Usuario usuario) {
        ArrayList<Usuario> listaUsuarios = getListaUsuarios(context);
        if (context.getClass() == LoginActivity.class && listaUsuarios.contains(usuario)) {
            usuarioLogado = listaUsuarios.get(listaUsuarios.indexOf(usuario));
            return true;
        } else {
            return false;
        }
    }

}
