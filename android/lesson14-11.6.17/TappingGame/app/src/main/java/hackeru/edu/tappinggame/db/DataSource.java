package hackeru.edu.tappinggame.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import hackeru.edu.tappinggame.infrastructure.UserScore;

/**
 * Created by hackeru on 11/06/2017.
 */

public class DataSource {

    private static DataSource instance;
    private SQLiteDatabase db;

    private DataSource(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    public static DataSource getInstance(Context context){
        if (instance == null){
            instance = new DataSource(context);
        }
        return instance;
    }

    public long insertData(String name, double score){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COL_NAME, name);
        values.put(DBOpenHelper.COL_SCORE, score);
        return db.insert(
                DBOpenHelper.TABLE_SCORES,
                null,
                values
        );
    }

    public UserScore[] getData(int limit){
        Cursor cursor = db.query(
                DBOpenHelper.TABLE_SCORES,
                new String[]{DBOpenHelper.COL_NAME, DBOpenHelper.COL_SCORE},
                null,
                null,
                null,
                null,
                DBOpenHelper.COL_SCORE + " DESC",
                String.valueOf(limit)
        );

        UserScore[] scores = null;
        if (cursor != null && cursor.moveToFirst()){
            scores = new UserScore[cursor.getCount()];
            int counter = 0;
            do {
                String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
                double score = cursor.getDouble(cursor.getColumnIndex(DBOpenHelper.COL_SCORE));
                scores[counter++] = new UserScore(name, score);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return scores;
    }

}
