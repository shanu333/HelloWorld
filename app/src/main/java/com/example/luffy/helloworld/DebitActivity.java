package com.example.luffy.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DebitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit);
        final Button caclulate = findViewById(R.id.calculate);
        caclulate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                calcualteInterest();
            }
        });
    }


    private void calcualteInterest() {
        final EditText amount = findViewById(R.id.amountTextView);
        final EditText rate = findViewById(R.id.rateTextView);
        final EditText startDate = findViewById(R.id.startDateTextView);
        final EditText endDate = findViewById(R.id.endDateTextView);
        final TextView finalText = findViewById(R.id.finalAnswer);
        String answer = "Calulate for ";
        answer = answer + amount.getText() + ",";
        answer = answer + rate.getText() + ",";
        answer = answer + startDate.getText() + ",";
        answer = answer + endDate.getText() + ".";
        finalText.setText(answer);
    }

}
