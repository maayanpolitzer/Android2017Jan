package maayan.example.com.whatsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 12/07/2017.
 */

public class DbOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;

    public static final String TABLE_MESSAGES = "messages";
    public static final String COL_ID = "_id";
    public static final String COL_FROM = "_from";
    public static final String COL_TO = "_to";
    public static final String COL_MESSAGE = "_message";

    private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_MESSAGES +
            " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_FROM + " INTEGER, " +
            COL_TO + " INTEGER, " +
            COL_MESSAGE + " TEXT)";

    public DbOpenHelper(Context context){
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
