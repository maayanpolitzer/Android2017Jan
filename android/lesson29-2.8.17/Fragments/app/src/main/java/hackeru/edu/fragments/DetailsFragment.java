package hackeru.edu.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hackeru on 02/08/2017.
 */

public class DetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        TextView nameTV = (TextView) view.findViewById(R.id.nameTV);
        Bundle bundle = getArguments();
        nameTV.setText(bundle.getString("NAME"));

        return view;
    }
}
