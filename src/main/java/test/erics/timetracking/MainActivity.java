package test.erics.timetracking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when user taps the Start your day button
    public void startDay(View view) {
        // TODO: Start the Next activity for main use
        Intent intent = new Intent(this, TimeTrackingActivity.class);
        startActivity(intent);
    }

    // Called when user taps the Settings button
    public void settings(View view) {
        // TODO: Start the Activity for app settings
    }

    // Called when user taps the Exit Button
    public void exit(View view) {
        // TODO: Exit the app
    }
}
