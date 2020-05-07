package com.example.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float decMonthlyPayments;
    int intYears;
    float decPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText monthlyPayments = (EditText) findViewById(R.id.txtMonthlyPayment);
        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText principal = (EditText) findViewById(R.id.txtPrincipal);
        Button button = (Button) findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decMonthlyPayments = Float.parseFloat(monthlyPayments.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                decPrincipal = Float.parseFloat(principal.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decMonthlyPayments);
                editor.putInt("key2", intYears);
                editor.putFloat("key3", decPrincipal);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}
