package com.example.android.egypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void question1(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Imhotep:
                if (checked)
                    score++;
                break;
        }
    }
    public void question2(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Giza:
                if (checked)
                    score++;
                break;
        }
    }
    public void question3(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Nile:
                if (checked)
                    score++;
                break;
        }
    }
    public void question4(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Sinai:
                if (checked)
                    score++;
                break;
        }
    }
    public void question5(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.Cleopatra:
                if (checked)
                    score++;
                break;
        }
    }
    public void submit(View view){
        if(score==5)
            Toast.makeText(getApplicationContext(), "congrats you got them all right " ,  Toast.LENGTH_SHORT).show();
        else
          Toast.makeText(getApplicationContext(), "Your score is " + score,  Toast.LENGTH_SHORT).show();

    }
}
