package sorry.aldan.ti3a_8_uts;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sorry.aldan.ti3a_8_uts.libraries.DataHelper;
import sorry.aldan.ti3a_8_uts.libraries.KotaDatabase;
import sorry.aldan.ti3a_8_uts.libraries.KotaRepository;
import sorry.aldan.ti3a_8_uts.models.RP_Kota;

public class Main3Activity extends AppCompatActivity {

    EditText edtNama;
    Button btnInput,btnListKota;

    DataHelper dataHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        edtNama = findViewById(R.id.edtNama);
        btnInput = findViewById(R.id.btnInput);
        btnListKota = findViewById(R.id.btnListKota);

        dataHelper = new DataHelper(this);

        final KotaDatabase db = Room.databaseBuilder(getApplicationContext(), KotaDatabase.class, "db_task")
                .allowMainThreadQueries()
                .build();

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RP_Kota rp = new RP_Kota(edtNama.getText().toString());
                db.daoAccess().insertTask(rp);
                String nama = edtNama.getText().toString();
//                kotaRepository.insertTask(nama);

//                dataHelper.insertDataKota(edtNama.getText().toString());
                Toast.makeText(Main3Activity.this,"Insert Berhasil",Toast.LENGTH_LONG).show();
            }
        });

        btnListKota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(i);
            }
        });
    }
}
