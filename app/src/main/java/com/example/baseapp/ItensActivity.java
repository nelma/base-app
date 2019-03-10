package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItensActivity extends AppCompatActivity {

    private EditText edNameItem;
    private EditText edDescription;
    private Button btSaveItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);


        edNameItem = findViewById(R.id.edNameItem);
        edDescription = findViewById(R.id.edDescription);
        btSaveItem = findViewById(R.id.btSaveItem);

        btSaveItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edNameItem.getText().toString().isEmpty() || edDescription.getText().toString().isEmpty()) {
                    Toast.makeText(ItensActivity.this, "Campos obrigatórios", Toast.LENGTH_LONG).show();

                    if(edNameItem.getText().toString().isEmpty()) edNameItem.setError("Digite o Nome do Item");
                    if(edDescription.getText().toString().isEmpty()) edDescription.setError("Digite a Descrição do Item");

                }
            }
        });
    }
}
