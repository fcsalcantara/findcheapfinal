package br.uva.findcheap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.uva.findcheap.model.Produto;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // Oculta a barra de título
        setContentView(R.layout.activity_principal);

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Cerveja", "Heineken", "Heineke Puro Malte 600ml", "600ml"));
        produtos.add(new Produto("Cereal", "Kellogs", "Sucrilhos 600g", "600g"));
        produtos.add(new Produto("Cerveja", "Antartica", "Antartica Original 600ml", "600ml"));
        produtos.add(new Produto("Rum", "Baccardi", "Baccardi Rum Carta Oro 976ml", "976ml"));

        ListView listaDeProdutos = (ListView) findViewById(R.id.listaProdutos);

        ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>(this, android.R.layout.simple_list_item_1, produtos);

        listaDeProdutos.setAdapter(adapter);

        Toast.makeText(getApplicationContext(), "Usuário " + MainActivity.getUsuarioLogado() + " logado", Toast.LENGTH_SHORT).show();
    }


    public void entrarProdutoOnClick(View v) {
        startActivity(new Intent(this, EntradaProdutoActivity.class));
    }

}
