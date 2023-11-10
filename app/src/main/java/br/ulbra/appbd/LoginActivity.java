package br.ulbra.appbd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edLogin, edPass;
    Button btnLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstancesStace){
        super.onCreate (savedInstancesStace);
        setContentView(R.layout.login);

        db = new DBHelper(this);
        edLogin = (EditText) findViewById(R.id.txtLoginUsu);
        edPass = (EditText) findViewById(R.id.txtPas1);
        btnLogin = (Button) findViewById(R.id.btnLogar);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edLogin.getText().toString();
                String password = edPass.getText().toString();
                if(username.equals("")){
                    Toast.makeText(LoginActivity.this ,"Usuário não inserido, tente novamente",
                            Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Senha não inserida, tente novamente",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Login: "+username+" pass: "+password, Toast.LENGTH_SHORT).show();
                    String res = db.validarLogin(username,password);

                    if(res.equals("OK")){
                        Toast.makeText(LoginActivity.this,"Login OK !!",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this,"Login ou Senha erra(s)!!",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
