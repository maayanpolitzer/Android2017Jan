package hackeru.edu.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hackeru on 02/08/2017.
 */

public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ArrayList<String> names = new ArrayList<>();
    private NameAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        names.add("Moshe");
        names.add("Yossi");

        ListView listView = (ListView) view.findViewById(R.id.lv);

        adapter = new NameAdapter(getActivity(), names);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        return view;
    }

    public void addName(String name){
        names.add(name);
        adapter.notifyDataSetChanged();
    }

    public void editName(String name, int position){
        names.set(position, name);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        ((RowClickListener) getActivity()).onRowClicked(names.get(position));
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Are you sure?")
                .setMessage("You are about to delete " + names.get(position))
                .setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        names.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
        return true;
    }
}
