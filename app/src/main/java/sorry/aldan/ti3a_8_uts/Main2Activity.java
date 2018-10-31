package sorry.aldan.ti3a_8_uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

import sorry.aldan.ti3a_8_uts.libraries.SessionManagement;

public class Main2Activity extends AppCompatActivity {

    TextView txtUsername;
    Button btnDatabase;

    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtUsername = findViewById(R.id.txtUsername);
        btnDatabase = findViewById(R.id.btnDatabase);

        sessionManagement = new SessionManagement(this);

        HashMap<String,String> userInformation = sessionManagement.getUserInformation();

        txtUsername.setText(userInformation.get(sessionManagement.KEY_EMAIL));

        btnDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });
    }
}
