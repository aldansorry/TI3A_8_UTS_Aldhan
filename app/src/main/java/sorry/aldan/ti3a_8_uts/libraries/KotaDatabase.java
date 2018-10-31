package sorry.aldan.ti3a_8_uts.libraries;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import sorry.aldan.ti3a_8_uts.models.RP_Kota;

@Database(entities = {RP_Kota.class}, version = 1, exportSchema = false)
public abstract class KotaDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}