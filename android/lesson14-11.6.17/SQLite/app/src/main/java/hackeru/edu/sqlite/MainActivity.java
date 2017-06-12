package hackeru.edu.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    //private final static String TAG = "MainActivity";

    /*
        Log.i(TAG, "i");
        Log.d(TAG, "d");
        Log.w(TAG, "w");
        Log.e(TAG, "e");
        */

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();


        //insertData("Moshe", 4);

        //updateData(117, 2);

        //deleteData(1);

        query();

    }

    private void query() {
        Cursor cursor = db.query(
                DbHelper.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        if (cursor != null && cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(DbHelper.COL_NAME));
                Log.d(TAG, name);
            }while(cursor.moveToNext());
        }
        /*
        while(cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(DbHelper.COL_NAME));
            Log.d(TAG, name);
        }
        */


    }

    private void deleteData(int id){
        /*
        db.delete(
                DbHelper.TABLE_NAME,
                DbHelper.COL_ID + "=" + id,
                null
        );
        */
        db.delete(
                DbHelper.TABLE_NAME,
                DbHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
    }

    private void updateData(int newAge, int id){
        ContentValues values = new ContentValues();
        values.put(DbHelper.COL_AGE, newAge);

        db.update(
                DbHelper.TABLE_NAME,
                values,
                DbHelper.COL_ID + "=" + id,
                null
        );
        /*
        db.update(
                DbHelper.TABLE_NAME,
                values,
                DbHelper.COL_ID + "=?",
                new String[]{String.valueOf(id)}
        );
        */
    }

    private void insertData(String name, int age){
        ContentValues values = new ContentValues();
        values.put(DbHelper.COL_NAME, name);
        values.put(DbHelper.COL_AGE, age);
        db.insert(DbHelper.TABLE_NAME, null, values);
    }

}
