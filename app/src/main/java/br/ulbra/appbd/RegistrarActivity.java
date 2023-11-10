package br.ulbra.appbd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarActivity extends AppCompatActivity {
    EditText edNome, edUSer, edPas1, edPas2;
    Button btSalvar;

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar);

        db = new DBHelper(this);

        edNome = (EditText) findViewById(R.id.txtNomeUsu);
        edUSer = (EditText) findViewById(R.id.txtLoginUsu);
        edPas1 = (EditText) findViewById(R.id.txtPas1);
        edPas2 = (EditText) findViewById(R.id.txtPas2);

        btSalvar = (Button) findViewById(R.id.btnSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = edUSer.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_LONG).show();
                } else if (pas1.equals("") || pas2.equals("")) {
                    Toast.makeText(RegistrarActivity.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_LONG).show();
                } else if (!pas1.equals(pas2)) {
                    Toast.makeText(RegistrarActivity.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegistrarActivity.this, "Login: "+userName+" senha: "+pas1, Toast.LENGTH_SHORT).show();
                    long res = db.criarUtilizador(userName, pas1);
                    Toast.makeText(RegistrarActivity.this, userName+"  "+res, Toast.LENGTH_SHORT).show();
                    if (res > 0) {

                        Toast.makeText(RegistrarActivity.this, "Registro OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegistrarActivity.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
