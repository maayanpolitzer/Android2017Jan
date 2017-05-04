package hackeru.edu.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 03/05/2017.
 */

public class MyAdapter extends ArrayAdapter<Action>{

    private Context context;
    private Action[] actions;

    public MyAdapter(Context context, Action[] actions){
        super(context, R.layout.list_item, actions);
        this.context = context;
        this.actions = actions;
    }

    private class ViewHolder {
        TextView titleTV;
        ImageView iconIV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            // TODO: 03/05/2017 inflate R.layout.list_item to view object.
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.titleTV = (TextView) convertView.findViewById(R.id.list_item_title_text_view);
            holder.iconIV = (ImageView) convertView.findViewById(R.id.list_item_icon_image_view);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTV.setText(actions[position].getTitle());
        holder.iconIV.setImageResource(actions[position].getIcon());
        return convertView;
    }
}
