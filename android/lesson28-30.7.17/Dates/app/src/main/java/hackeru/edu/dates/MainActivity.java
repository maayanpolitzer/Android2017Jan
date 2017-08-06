package hackeru.edu.dates;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.dateBtn);
        btn.setOnClickListener(this);

        /*
        EditText et = new EditText(this);
        et.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        */



    }

    @Override
    public void onClick(View view) {
        Calendar now = Calendar.getInstance();
        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                Calendar pickDate = Calendar.getInstance();
                pickDate.set(year,month, dayOfMonth);
                btn.setText(pickDate.getTime().toString());
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)).show();
    }
}
