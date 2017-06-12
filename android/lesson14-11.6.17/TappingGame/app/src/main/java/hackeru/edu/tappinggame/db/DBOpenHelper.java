package hackeru.edu.tappinggame.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 11/06/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;

    public static final String TABLE_SCORES = "scores";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_SCORE = "score";

    private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_SCORES + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_SCORE + " REAL)";

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
