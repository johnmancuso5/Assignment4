package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickedTip(View view){

        // For the Toast
        Context context = getApplicationContext();
        CharSequence text = "Empty of incorrect value(s)";
        int duration = Toast.LENGTH_LONG;

        String checkString = ((EditText)findViewById(R.id.checkAmountValue)).getText().toString();
        String partyString = ((EditText)findViewById(R.id.partySizeValue)).getText().toString();

        if(checkString.equals("")){
            Toast.makeText(this, text, duration).show();
            return;
        }

        if(partyString.equals("")){
            Toast.makeText(this, text, duration).show();
            return;
        }

        double checkInt = Double.parseDouble(checkString);
        int partyInt = Integer.parseInt(partyString);

        if(checkInt <= 0 && partyInt <= 0) {
            Toast.makeText(this, text, duration).show();
            return;
        }

        else {
            // 15%
            ((EditText) findViewById(R.id.fifteenPercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 15));
            ((EditText) findViewById(R.id.fifteenPercentTotalValue)).setText(tipTotal(checkInt, partyInt, 15));

            // 20%
            ((EditText) findViewById(R.id.twentyPercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 20));
            ((EditText) findViewById(R.id.twentyPercentTotalValue)).setText(tipTotal(checkInt, partyInt, 20));

            // 25%
            ((EditText) findViewById(R.id.twentyfivePercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 25));
            ((EditText) findViewById(R.id.twentyfivePercentTotalValue)).setText(tipTotal(checkInt, partyInt, 25));
        }
    }

    public String tipPerPerson(double total, int size, int percent){
        double value = (total / size) * (percent / 100.0);

        return Integer.toString((int) Math.ceil(value));
    }

    public String tipTotal(double total, int size, int percent){
        double value = (total / size) + (total / size * (percent / 100.0));

        return Integer.toString((int) Math.ceil(value));
    }

}