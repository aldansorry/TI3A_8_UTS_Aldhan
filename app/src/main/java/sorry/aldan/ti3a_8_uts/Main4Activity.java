package sorry.aldan.ti3a_8_uts;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import sorry.aldan.ti3a_8_uts.adapters.KotaViewAdapter;
import sorry.aldan.ti3a_8_uts.libraries.DataHelper;
import sorry.aldan.ti3a_8_uts.models.Kota;

public class Main4Activity extends AppCompatActivity {

    RecyclerView rvKota;
    RecyclerView.LayoutManager lm;
    KotaViewAdapter kotaViewAdapter;

    Button btnTambah;

    DataHelper dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        rvKota = findViewById(R.id.rvKota);
        btnTambah = findViewById(R.id.btnTambah);

        dataHelper = new DataHelper(this);
        lm = new LinearLayoutManager(this);

        rvKota.setLayoutManager(lm);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main4Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });
        refreshList();
    }
    public void refreshList(){
        kotaViewAdapter = new KotaViewAdapter(dataHelper.getDataKota());
        rvKota.setAdapter(kotaViewAdapter);
    }
}
