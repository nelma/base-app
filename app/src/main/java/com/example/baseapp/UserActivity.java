package com.example.baseapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPassword;
    private Button btSave;

    static final int REQUEST_CODE = 2;
    static final String NAME = "NAME";
    static final String PASSWORD = "PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final Bundle bundle = getIntent().getExtras();

        userName = findViewById(R.id.userName);
        userPassword = findViewById(R.id.userPassword);
        btSave = findViewById(R.id.btSave);

        userName.setText(bundle.getString("NOME"));
        userPassword.setText(bundle.getString("SENHA"));

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(userName.getText().toString().isEmpty() || userPassword.getText().toString().isEmpty()) {
                    Toast.makeText(UserActivity.this, "Os Campos são obrigatórios", Toast.LENGTH_LONG).show();
                } else {

                    User user = new User(userName.getText().toString(), userPassword.getText().toString());

                    Intent intent = new Intent(UserActivity.this, DrawerActivity.class);
                    intent.putExtra("NOME", user.getNome());
                    startActivityForResult(intent, REQUEST_CODE );
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(NAME, userName.getText().toString());
        outState.putString(PASSWORD, userPassword.getText().toString());

        User user =
                new User(userName.getText().toString(), userPassword.getText().toString());

        outState.putParcelable("USUARIO_PARCELABLE", user);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String nome = savedInstanceState.getString(NAME);
        String password = savedInstanceState.getString(PASSWORD);


        userName.setText(nome);
        userPassword.setText(password);

        User user = savedInstanceState.getParcelable("USUARIO_PARCELABLE");
        if (user != null) {
            Log.d(getClass().getName(), user.getNome());
        }
    }
}
