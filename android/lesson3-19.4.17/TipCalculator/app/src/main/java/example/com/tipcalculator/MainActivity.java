package example.com.tipcalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText percentET;
    private EditText billET;
    private RadioGroup group;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billET = (EditText) findViewById(R.id.activity_main_total_bill_edit_text);
        percentET = (EditText) findViewById(R.id.activity_main_percent_edit_text);
        group = (RadioGroup) findViewById(R.id.activity_main_radio_group);
        Button calculateBtn = (Button) findViewById(R.id.activity_main_calculate_button);
        textView = (TextView) findViewById(R.id.activity_main_text_view);

        calculateBtn.setOnClickListener(this);
        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        String priceAsString = billET.getText().toString();
        if (priceAsString.isEmpty()){
            billET.setError("Cannot be empty");
            return;
        }
        double price = Double.parseDouble(priceAsString);
        switch(group.getCheckedRadioButtonId()){
            case R.id.first:
                calculate(price, 10);
                break;
            case R.id.second:
                calculate(price, 20);
                break;
            default:
                String percentAsString = percentET.getText().toString();
                if (percentAsString.isEmpty()){
                    percentET.setError("cannot be empty");
                    return;
                }
                double percent = Double.parseDouble(percentAsString);
                calculate(price, percent);
        }

    }

    private void calculate(double price, double percent){
        double result = (price * percent) / 100;
        textView.setText("You need to pay: " + result);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
        /*
        if (id == R.id.other){
            percentET.setVisibility(View.VISIBLE);
        }else{
            percentET.setVisibility(View.INVISIBLE);
        }
        */
        percentET.setVisibility(id == R.id.other ? View.VISIBLE : View.INVISIBLE);
    }
}
