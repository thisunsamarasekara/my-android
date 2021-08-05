package com.example.tutorial2;

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
    Button btn_calculate;
    TextView tv_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_temp = findViewById(R.id.et_temp);
        rd_btn_C = findViewById(R.id.rd_btn_C);
        rd_btn_F = findViewById(R.id.rd_btn_F);
        btn_calculate = findViewById(R.id.btn_calculate);
        tv_answer     = findViewById(R.id.tv_answer);

    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){
        Calculation cal = new Calculation();
        String value = et_temp.getText().toString(); //get the value user entered

        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Enter the Temperature",Toast.LENGTH_SHORT).show();
        }
        else{
            Float temp = Float.parseFloat(value); //convert string to float

            if(rd_btn_C.isChecked()){ //check whether celcius button is clicked

                temp = cal.convertCelciusToFahrenheit(temp);
            }
            else if(rd_btn_F.isChecked()) {//check whether fahrenhite button is clicked
                temp = cal.convertFahrenheitToCelcius(temp);
            }
            else{ //if user forget to click any radio button
                Toast.makeText(this, "Select a radio button", Toast.LENGTH_SHORT).show();
                temp = 0.0f;
            }
            tv_answer.setText(new Float(temp).toString());
        }
    }


}