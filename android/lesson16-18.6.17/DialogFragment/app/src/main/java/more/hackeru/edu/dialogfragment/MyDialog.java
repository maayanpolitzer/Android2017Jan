package more.hackeru.edu.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hackeru on 18/06/2017.
 */

public class MyDialog extends DialogFragment implements View.OnClickListener {

    private EditText numberET;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_my, null);

        Button btn = (Button) view.findViewById(R.id.dialog_my_choose_button);
        btn.setOnClickListener(this);

        int number = getArguments().getInt("NUMBER");
        numberET = (EditText) view.findViewById(R.id.dialog_my_number_edit_text);
        numberET.setText(number + "");

        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(view)
                .create();

             return dialog;
    }

    @Override
    public void onClick(View view) {
        DataListener listener = (DataListener) getActivity();
        String str = numberET.getText().toString();
        if (str.isEmpty()){
            return;
        }
        int number = Integer.parseInt(str);
        listener.onNumberSet(number);
        dismiss();
    }
}
