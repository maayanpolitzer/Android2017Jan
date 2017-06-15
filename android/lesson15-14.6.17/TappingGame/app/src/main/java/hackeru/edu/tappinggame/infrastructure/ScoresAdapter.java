package hackeru.edu.tappinggame.infrastructure;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import hackeru.edu.tappinggame.R;
import hackeru.edu.tappinggame.db.DBOpenHelper;

/**
 * Created by hackeru on 14/06/2017.
 */

public class ScoresAdapter extends CursorAdapter {

    public ScoresAdapter(Context context, Cursor cursor){
        super(context, cursor, false);
    }

    private class ViewHolder {
        TextView tv;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        ViewHolder holder = new ViewHolder();
        holder.tv = (TextView) view.findViewById(R.id.list_item_text_view);
        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
        double score = cursor.getDouble(cursor.getColumnIndex(DBOpenHelper.COL_SCORE));
        holder.tv.setText(name + " " + score);
    }

}
