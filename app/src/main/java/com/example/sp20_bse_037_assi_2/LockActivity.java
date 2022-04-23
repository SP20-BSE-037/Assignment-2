package com.example.sp20_bse_037_assi_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

//import butterknife.BindViews;
//import butterknife.ButterKnife;
//import butterknife.OnClick;

public class LockActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_back, btn_open;


    List<View> btnNumPads;

    List<ImageView> dots;

    private static final String TRUE_CODE = "2869";
    private static final int MAX_LENGHT = 4;
    private String codeString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);


        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn_back = findViewById(R.id.btn_back);
        btn_open = findViewById(R.id.btn_open);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.btn_back) {
                    public void onClear () {
                        if (codeString.length() > 0) {

                            codeString = removeLastChar(codeString);
                        }

                    }
                }
            }
        });

    }

    @Override
    public void onClick(View view) {

        public void onClick (Button button){
            getStringCode(button.getId());
            if (codeString.length() == MAX_LENGHT) {
                if (codeString.equals(TRUE_CODE)) {
                    Toast.makeText(this, "Code is right", Toast.LENGTH_SHORT).show();
                    setIsPass();
                    finish();
                } else {
                    Toast.makeText(this, "Wrong Pass code", Toast.LENGTH_SHORT).show();

                }
            } else if (codeString.length() > MAX_LENGHT) {
                //reset the input code
                codeString = "";
                getStringCode(button.getId());
            }
        }
        private void getStringCode ( int buttonId){
            switch (buttonId) {
                case R.id.btn0:
                    codeString += "0";
                    break;
                case R.id.btn1:
                    codeString += "1";
                    break;
                case R.id.btn2:
                    codeString += "2";
                    break;
                case R.id.btn3:
                    codeString += "3";
                    break;
                case R.id.btn4:
                    codeString += "4";
                    break;
                case R.id.btn5:
                    codeString += "5";
                    break;
                case R.id.btn6:
                    codeString += "6";
                    break;
                case R.id.btn7:
                    codeString += "7";
                    break;
                case R.id.btn8:
                    codeString += "8";
                    break;
                case R.id.btn9:
                    codeString += "9";
                    break;
                default:
                    break;
            }
        }


       public String removeLastCar (String s){
            if (s == null || s.length() == 0){
                return s;
            }
            return s.substring(0, s.length() -1);
        }

        public void setIsPass () {
            SharedPreferences.Editor editor = getSharedPreferences("PASS_CODE", MODE_PRIVATE).edit();
            editor.putBoolean("is_pass", true);
            editor.apply();
        }

    }
}