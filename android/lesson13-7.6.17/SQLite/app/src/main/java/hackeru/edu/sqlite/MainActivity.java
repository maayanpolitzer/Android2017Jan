package hackeru.edu.sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        //insertData("Moshe", 23);
        //insertData("Moshe", 4);

        //updateData(117, 2);

        deleteData(1);

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
