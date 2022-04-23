package com.example.sp20_bse_037_assi_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;

import android.widget.TextView;

//import butterknife.BindView;
//import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

   // @BindView(R.id.toolbar)
    Toolbar toolbar;

   // @BindView(R.id.text)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // ButterKnife.bind(this);

        setSupportActionBar(toolbar);

    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onStart() {
        super.onStart();
        if (!isPass()) {
            Intent intent = new Intent(this, LockActivity.class);
            startActivity(intent);
        } else {
            textView.setText("The code you typed is right!");
        }
    }

    private boolean isPass() {
        SharedPreferences prefs = getSharedPreferences("PASS_CODE", MODE_PRIVATE);
        return prefs.getBoolean("is_pass", false);
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = getSharedPreferences("PASS_CODE", MODE_PRIVATE).edit();
        editor.putBoolean("is_pass", false);
        editor.apply();
    }
}