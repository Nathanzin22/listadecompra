package com.software.listadecompra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtProduto = findViewById(R.id.textProduto);
        EditText txtMarca = findViewById(R.id.textMarca);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        ListView listProdutos = findViewById(R.id.listaProdutos);
        List<Produto> dadProdutos = new ArrayList<>();

        ArrayAdapter adapter;
        adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dadProdutos);

        listProdutos.setAdapter(adapter);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produto produto = new Produto();

                produto.setNome(txtProduto.getText().toString());
                produto.setMarca(txtMarca.getText().toString());

                dadProdutos.add(produto);
                adapter.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Salvo!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}