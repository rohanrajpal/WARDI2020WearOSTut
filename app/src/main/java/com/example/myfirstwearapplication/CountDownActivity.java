package com.example.myfirstwearapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.wear.activity.ConfirmationActivity;
import androidx.wear.widget.CircularProgressLayout;

public class CountDownActivity extends Activity implements
        CircularProgressLayout.OnTimerFinishedListener, View.OnClickListener {
    private CircularProgressLayout circularProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        circularProgress =
                (CircularProgressLayout) findViewById(R.id.circular_progress);
        circularProgress.setOnTimerFinishedListener(this);
        circularProgress.setOnClickListener(this);

        // Two seconds to cancel the action
        circularProgress.setTotalTime(3000);
        // Start the timer
        circularProgress.startTimer();
    }

    @Override
    public void onTimerFinished(CircularProgressLayout layout) {
        // User didn't cancel, perform the action
        displayConfirmation("Completed",this);
        returnMessage("You completed the timer");
        finish();
    }

    @Override
    public void onClick(View view) {
        if (view.equals(circularProgress)) {
            // User canceled, abort the action
            circularProgress.stopTimer();

            displayConfirmation("Cancelled",this);
            returnMessage("You cancelled the timer");
            finish();
        }
    }

    public void displayConfirmation(String message, Context context){
        Intent intent = new Intent(context, ConfirmationActivity.class);
        intent.putExtra(ConfirmationActivity.EXTRA_ANIMATION_TYPE,
                ConfirmationActivity.SUCCESS_ANIMATION);
        intent.putExtra(ConfirmationActivity.EXTRA_MESSAGE,
                message);
        startActivity(intent);
    }

    public void returnMessage(String message){
        Intent intent = new Intent();
        intent.putExtra("keyName", message);
        setResult(RESULT_OK, intent);
    }
}
