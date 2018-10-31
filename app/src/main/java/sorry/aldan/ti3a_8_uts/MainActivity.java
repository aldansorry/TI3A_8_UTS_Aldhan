package sorry.aldan.ti3a_8_uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sorry.aldan.ti3a_8_uts.libraries.SessionManagement;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button btnLogin;

    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        sessionManagement = new SessionManagement(this);

        if(sessionManagement.isLoggedIn()){
            goToActivity();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();
                if(username.matches("") || username.trim().isEmpty() || password.matches("") || password.trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Username dan Passsword Tidak Boleh Kosong atau spasi"
                            ,Toast.LENGTH_LONG).show();
                }else {
                    sessionManagement.createLoginSession(username, password);
                    goToActivity();
                }
            }
        });
    }
    private void goToActivity(){
        Intent mIntent = new Intent(this,Main2Activity.class);
        startActivity(mIntent);
    }
}
