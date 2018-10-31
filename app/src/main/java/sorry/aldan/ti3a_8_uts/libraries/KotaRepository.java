package sorry.aldan.ti3a_8_uts.libraries;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import sorry.aldan.ti3a_8_uts.models.RP_Kota;

public class KotaRepository {
    private String DB_NAME = "db_task";

    private KotaDatabase kotaDatabase;
    public KotaRepository(Context context) {
        kotaDatabase = Room.databaseBuilder(context, KotaDatabase.class, DB_NAME).build();
    }

    public void insertTask(String nama) {
        kotaDatabase.daoAccess().insertTask(new RP_Kota(nama));
    }

    public LiveData<RP_Kota> getTask(int id) {
        return kotaDatabase.daoAccess().getTask(id);
    }

    public LiveData<List<RP_Kota>> getTasks() {
        return kotaDatabase.daoAccess().fetchAllTasks();
    }
}
