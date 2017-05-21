package hackeru.edu.moviesapp;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by hackeru on 17/05/2017.
 */

public class MoviesAdapter extends ArrayAdapter<Movie> {

    private LayoutInflater inflater;
    private ArrayList<Movie> movies;
    private Handler handler;
    private Context context;

    public MoviesAdapter(Context context, ArrayList<Movie> movies){
        super(context, R.layout.list_item, movies);
        inflater = LayoutInflater.from(context);
        this.movies = movies;
        this.context = context;
        handler = new Handler();
    }

    private class ViewHolder {
        ImageView posterIV;
        TextView titleTV, yearTV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.posterIV = (ImageView) convertView.findViewById(R.id.list_item_poster_image_view);
            viewHolder.titleTV = (TextView) convertView.findViewById(R.id.list_item_title_text_view);
            viewHolder.yearTV = (TextView) convertView.findViewById(R.id.list_item_year_text_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //new DownloadImageThread(movies.get(position).getPoster(),viewHolder.posterIV,handler).start();
        Picasso.with(context).load(movies.get(position).getPoster()).into(viewHolder.posterIV);

        viewHolder.titleTV.setText(movies.get(position).getTitle());
        viewHolder.yearTV.setText(movies.get(position).getYear());

        return convertView;
    }


}
