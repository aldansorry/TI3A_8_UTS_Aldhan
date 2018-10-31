package sorry.aldan.ti3a_8_uts.libraries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import sorry.aldan.ti3a_8_uts.models.Kota;

public class DataHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "data.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_KOTA = "CREATE TABLE kota(nama text NOT NULL)";
    private static final String TABLE_KOTA = "kota";
    private static final String KEY_NAMA = "nama";

    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_KOTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public ArrayList<Kota> getDataKota(){
        ArrayList<Kota> ret = new ArrayList<Kota>();
        Cursor cursor;
        SQLiteDatabase db = getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM "+TABLE_KOTA,null);
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            ret.add(new Kota(cursor.getString(0).toString()));
        }
        return ret;
    }

    public void insertDataKota(String nama){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("insert into "+TABLE_KOTA+" ("+KEY_NAMA+") values ('"+nama+"')");
    }
}
