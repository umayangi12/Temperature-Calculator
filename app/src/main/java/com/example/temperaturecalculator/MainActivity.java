package com.example.temperaturecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_temp;
    RadioButton rd_btn_C;
    RadioButton rd_btn_F;
    Button btn_calc;
    TextView tv_calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rd_btn_C = findViewById(R.id.rd_btn_C);
        rd_btn_F = findViewById(R.id.rd_btn_F);
        btn_calc = findViewById(R.id.btn_calc);
        tv_calc = findViewById(R.id.tv_calc);



    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    public void calculateAnswer() {
        Calculation cal = new Calculation();
        String value = et_temp.getText().toString();
        if (TextUtils.isEmpty(value)) {
            Toast.makeText(this, "Enter the temperature", Toast.LENGTH_SHORT).show();

        } else {
            Float temp = Float.parseFloat(value);
            if (rd_btn_C.isChecked()) {
                temp = cal.convertCelciusToFahrenheit(temp);

            } else if (rd_btn_F.isChecked()) {
                temp = cal.convertFahrenheitToCelcius(temp);

            } else {
                Toast.makeText(this, "Select the radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            tv_calc.setText(new Float(temp).toString());
        }
        }

        }

