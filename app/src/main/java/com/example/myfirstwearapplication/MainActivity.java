package com.example.myfirstwearapplication;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends WearableActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //means app will look into the resources folder, then the layouts folder and finally the activity main
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text);

        Button b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextView.setText("WARDI 2020");
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
