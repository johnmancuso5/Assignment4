package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickedTip(View view){
        String checkString = ((EditText)findViewById(R.id.checkAmountValue)).getText().toString();
        String partyString = ((EditText)findViewById(R.id.partySizeValue)).getText().toString();

        int checkInt = Integer.parseInt(checkString);
        int partyInt = Integer.parseInt(partyString);

        // 15%
        ((EditText)findViewById(R.id.fifteenPercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 15));
        ((EditText)findViewById(R.id.fifteenPercentTotalValue)).setText(tipTotal(checkInt, partyInt, 15));

        // 20%
        ((EditText)findViewById(R.id.twentyPercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 20));
        ((EditText)findViewById(R.id.twentyPercentTotalValue)).setText(tipTotal(checkInt, partyInt, 20));

        // 25%
        ((EditText)findViewById(R.id.twentyfivePercentTipValue)).setText(tipPerPerson(checkInt, partyInt, 25));
        ((EditText)findViewById(R.id.twentyfivePercentTotalValue)).setText(tipTotal(checkInt, partyInt, 25));
    }

    public String tipPerPerson(int total, int size, int percent){
        double value = (total / size) * (percent / 100.0);

        return Integer.toString((int) Math.ceil(value));
    }

    public String tipTotal(int total, int size, int percent){
        double value = (total / size) + (total / size * (percent / 100.0));

        return Integer.toString((int) Math.ceil(value));
    }

}