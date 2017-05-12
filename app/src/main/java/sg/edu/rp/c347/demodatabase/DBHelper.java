package sg.edu.rp.c347.demodatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.R.attr.version;


/**
 * Created by 15017199 on 12/5/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    //Start version with 1
    //increment by 1 whenever db schema changes.
    private static final int DATABASE_VER = 1;
    //filename of the database
    private static final String DATABASE_NAME = "tasks.db";
    private static final String TABLE_TASK = "task";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DESCRIPTION = "description"
    private static final String COLUMN_DATE = "date";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE "+TABLE_TASK+"("
                +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_DATE + " TEXT,"
                + COLUMN_DESCRIPTION + " TEXT )";
               db.execSQL(createTableSql);
               Log.i("info" ,"created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {

    }
}
