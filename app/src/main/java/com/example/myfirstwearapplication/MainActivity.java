package com.example.myfirstwearapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.wear.activity.ConfirmationActivity;

import java.util.List;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private int SECOND_ACTIVITY_REQCODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //means app will look into the resources folder, then the layouts folder and finally the activity main
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textmain);

        Button b1 = findViewById(R.id.button1);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CountDownActivity.class);
                startActivityForResult(intent,SECOND_ACTIVITY_REQCODE);
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }


    // This method is called when the second activity finishes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check that it is the SecondActivity with an OK result
        if (requestCode == SECOND_ACTIVITY_REQCODE) {
            if (resultCode == RESULT_OK) {

                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");

                mTextView.setText(returnString);
            }
        }
    }

}
