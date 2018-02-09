package trabalho.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.michelbarbosa.trabalhoconclusao.R;
import trabalho.android.dao.UsuarioDao;

/**
 * Created by summit-bra on 08/02/18.
 */

public class CadastroUserActivity extends AppCompatActivity {

    private EditText campoLogin;
    private EditText campoSenha;
    private UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        campoLogin = (EditText) findViewById(R.id.campo_login);
        campoSenha = (EditText) findViewById(R.id.campo_password);
        dao = new UsuarioDao(this);
    }

    public void cadastro(View view) {
        String login = campoLogin.getText().toString();
        String senha = campoSenha.getText().toString();
        new UsuarioDao(this).save(login, senha);

        goLogin();
    }

    public void goLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
