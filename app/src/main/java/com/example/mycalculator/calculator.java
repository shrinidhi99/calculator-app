package com.example.mycalculator;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity {
    // you need to save instances of both the numbers so that they do not disappear when orientation of the screen is changed (screen rotation)
    double answer,scians;
    EditText number1, number2, number;
    TextView ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        ans = (TextView) findViewById(R.id.answer);
        number = (EditText) findViewById(R.id.number);
    }
    public void closeKeyboard()
    {
        View view = this.getCurrentFocus();
        if(view!=null)
        {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    public void divide(View view) {
        if(number1.getText().toString().equals("") || number2.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number(s)!", Toast.LENGTH_SHORT).show();
        else {
            if (Float.parseFloat(number2.getText().toString()) == 0)
                ans.setText("Cannot divide by zero!");
            else {
                answer = Float.parseFloat(number1.getText().toString()) / Float.parseFloat(number2.getText().toString());
                ans.setText("" + answer);
            }
        }
        closeKeyboard();
    }

    public void multiply(View view) {
        if(number1.getText().toString().equals("") || number2.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number(s)!", Toast.LENGTH_SHORT).show();
        else {
            answer = Float.parseFloat(number1.getText().toString()) * Float.parseFloat(number2.getText().toString());
            ans.setText("" + answer);
        }
        closeKeyboard();
    }

    public void minus(View view) {
        if(number1.getText().toString().equals("") || number2.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number(s)!", Toast.LENGTH_SHORT).show();
        else {
            answer = Float.parseFloat(number1.getText().toString()) - Float.parseFloat(number2.getText().toString());
            ans.setText("" + answer);
        }
        closeKeyboard();
    }

    public void plus(View view) {
        if(number1.getText().toString().equals("") || number2.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number(s)!", Toast.LENGTH_SHORT).show();
        else {
            answer = Float.parseFloat(number1.getText().toString()) + Float.parseFloat(number2.getText().toString());
            ans.setText("" + answer);
        }
        closeKeyboard();
    }

    public void invf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            if (Float.parseFloat(number.getText().toString()) == 0) {
                Toast.makeText(calculator.this, "0 is not invertible!", Toast.LENGTH_SHORT).show();
            } else {
                scians = 1 / Float.parseFloat(number.getText().toString());
                ans.setText("" + scians);
            }
        }
        closeKeyboard();
    }

    public void xfactf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            if (Integer.parseInt(number.getText().toString()) == 0)
                ans.setText("1");
            else {
                scians = 1;
                int x = Integer.parseInt(number.getText().toString());
                while (x > 0) {
                    scians = scians * x;
                    --x;
                }
                ans.setText("" + scians);
            }
        }
        closeKeyboard();
    }

    public void sqrtf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            if (Float.parseFloat(number.getText().toString()) < 0)
                Toast.makeText(calculator.this, "Negative numbers not allowed!", Toast.LENGTH_SHORT).show();
            else {
                scians = Math.sqrt(Float.parseFloat(number.getText().toString()));
                ans.setText("" + scians);
            }
        }
        closeKeyboard();
    }

    public void tanf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            scians = Math.tan(Float.parseFloat(number.getText().toString()));
            ans.setText("" + scians);
        }
        closeKeyboard();
    }

    public void expf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            scians = Math.exp(Float.parseFloat(number.getText().toString()));
            ans.setText("" + scians);
        }
        closeKeyboard();
    }

    public void logf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            if (Float.parseFloat(number.getText().toString()) == 0) {
                Toast.makeText(calculator.this, "log(0) is not defined!", Toast.LENGTH_SHORT).show();
                ans.setText("Not defined!");
            }
            else {
                scians = Math.log(Float.parseFloat(number.getText().toString()));
                ans.setText("" + scians);
            }
        }
        closeKeyboard();
    }

    public void cosf(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(calculator.this, "The input has been taken in radians.", Toast.LENGTH_SHORT).show();
            scians = Math.cos(Float.parseFloat(number.getText().toString()));
            ans.setText("" + scians);
        }
        closeKeyboard();
    }

    public void sinef(View view) {
        if(number.getText().toString().equals(""))
            Toast.makeText(calculator.this, "Enter a real number!", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(calculator.this, "The input has been taken in radians.", Toast.LENGTH_SHORT).show();
            scians = Math.sin(Float.parseFloat(number.getText().toString()));
            ans.setText("" + scians);
        }
    closeKeyboard();
    }

    public void Clear(View view) {
        ans.setText("");
        number.setText("");
        number1.setText("");
        number2.setText("");
    }
}
