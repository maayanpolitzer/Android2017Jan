package maayan.example.com.whatsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hackeru on 12/07/2017.
 */

public class InsertDataThread extends Thread {

    private Context context;
    private int senderID;
    private int receiverID;
    private String content;

    public InsertDataThread(Context context, int senderID, int receiverID, String content) {
        this.context = context;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
    }

    @Override
    public void run() {
        DbOpenHelper helper = new DbOpenHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbOpenHelper.COL_FROM, senderID);
        values.put(DbOpenHelper.COL_TO, receiverID);
        values.put(DbOpenHelper.COL_MESSAGE, content);
        db.insert(
                DbOpenHelper.TABLE_MESSAGES,
                null,
                values
        );
    }
}
