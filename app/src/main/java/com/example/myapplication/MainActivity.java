package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView result;
        EditText height,weight;
        Button button;

        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        result=findViewById(R.id.result);
        button=findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float h = Float.parseFloat(height.getText().toString()); // Height should be float
                float wt = Float.parseFloat(weight.getText().toString());
                float bmi = wt / (h * h);

                if (bmi < 18.5) {
                    result.setText("Under Weight");
                } else if (bmi < 24.9) {
                    result.setText("Normal");
                } else if (bmi < 29.9) {
                    result.setText("Over Weight");
                } else if(bmi>=35){
                    result.setText("Obese");
                }
            }
        });




    }

}