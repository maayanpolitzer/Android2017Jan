package hackeru.edu.fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 02/08/2017.
 */

public class NameAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> names;

    public NameAdapter(Context context, ArrayList<String> names){
        super(context, R.layout.list_item, names);
        this.context = context;
        this.names = names;
    }

    private class ViewHolder {
        View iv;
        TextView nameTV;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.iv = convertView.findViewById(R.id.list_item_edit_image_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTV.setText(names.get(position));
        viewHolder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) context).editName(names.get(position), position);
            }
        });

        return convertView;
    }
}
