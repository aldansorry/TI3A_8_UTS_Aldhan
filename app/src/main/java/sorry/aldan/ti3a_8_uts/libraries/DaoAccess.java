package sorry.aldan.ti3a_8_uts.libraries;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import sorry.aldan.ti3a_8_uts.models.RP_Kota;

@Dao
public interface DaoAccess {

    @Insert
    void insertTask(RP_Kota...nama);

    @Query("SELECT * FROM RP_Kota")
    LiveData<List<RP_Kota>> fetchAllTasks();

    @Query("Select * from RP_Kota where id =:id")
    LiveData<RP_Kota> getTask(int id);
}
