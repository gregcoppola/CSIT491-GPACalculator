package com.coppola.csit491_gpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText g1,g2,g3,g4,g5;
    TextView total;
    RelativeLayout rl;

    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.compute);
        g1=(EditText)findViewById(R.id.g1);
        g2=(EditText)findViewById(R.id.g2);
        g3=(EditText)findViewById(R.id.g3);
        g4=(EditText)findViewById(R.id.g4);
        g5=(EditText)findViewById(R.id.g5);
        total=(TextView)findViewById(R.id.total);
        rl = findViewById(R.id.rl);
        rl.setBackgroundColor(Color.WHITE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x1, x2, x3, x4, x5;
                if (count % 2 == 0) {
                    if (g1.getText().toString().equals("") || g2.getText().toString().equals("") || g3.getText().toString().equals("") || g4.getText().toString().equals("") || g5.getText().toString().equals("")) {
                        total.setText("Please Enter Your Grades Above!");
                    }
                    else {
                        x1 = Float.parseFloat(g1.getText().toString());
                        x2 = Float.parseFloat(g2.getText().toString());
                        x3 = Float.parseFloat(g3.getText().toString());
                        x4 = Float.parseFloat(g4.getText().toString());
                        x5 = Float.parseFloat(g5.getText().toString());
                        float average = x1 + x2 + x3 + x4 + x5;
                        average = average / 5;
                        if (average < 60) {
                            total.setText(Float.toString(average));
                            rl.setBackgroundColor(Color.parseColor("#f53333"));
                        } else if (average >= 60 && average < 80) {
                            total.setText(Float.toString(average));
                            rl.setBackgroundColor(Color.parseColor("#edfa3c"));
                        } else if (average >= 80 && average <= 100) {
                            total.setText(Float.toString(average));
                            rl.setBackgroundColor(Color.parseColor("#55fa3c"));
                        }
                        count++;
                        button.setText("Clear");
                    }

                }
                else
                {
                    g1.setText("");
                    g2.setText("");
                    g3.setText("");
                    g4.setText("");
                    g5.setText("");
                    total.setText("");
                    button.setText("Compute GPA");
                    rl.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}

