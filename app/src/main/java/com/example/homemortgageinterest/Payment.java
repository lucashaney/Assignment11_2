package com.example.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView interestPaid = (TextView) findViewById(R.id.txtInterestPayment);
        ImageView image = (ImageView) findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decMonthlyPayments = sharedPref.getFloat("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        float decPrincipal = sharedPref.getFloat("key3", 0);
        float decInterestPaid;

        decInterestPaid = ((decMonthlyPayments * (intYears * 12)) - decPrincipal);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        interestPaid.setText("Total Interest Paid " + currency.format(decInterestPaid));
        if (intYears == 10) {
            image.setImageResource(R.drawable.ten);
        } else if (intYears == 20) {
            image.setImageResource(R.drawable.twenty);
        } else if (intYears == 30) {
            image.setImageResource(R.drawable.thirty);
        } else {
            interestPaid.setText("Enter 10, 20, or 30 years");
        }
    }
}
