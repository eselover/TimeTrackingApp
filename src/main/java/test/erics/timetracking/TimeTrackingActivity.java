package test.erics.timetracking;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimeTrackingActivity extends AppCompatActivity {

    public CustomAdapter adapter;
    public ArrayList<Client> clientList = new ArrayList<Client>();
    public int clientCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_tracking);

        CustomAdapter adapter = new CustomAdapter(clientList, this);

        ListView cList = (ListView) findViewById(R.id.client_listview);
        cList.setAdapter(adapter);

    }

    // Called when user taps the add button
    public void addClient(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.namePopUp);
        constraintLayout.setVisibility(View.VISIBLE);
    }

    // Called when user taps the pause button
    public void pauseTracking(View view) {
        // TODO: pause all active time counters
    }

    // Called when user taps the End Day button
    public void endDay(View view) {
        // TODO: End day, Calculate time spent report

    }


    public void doneNaming(View view) {
        EditText editText = (EditText) findViewById(R.id.client_name_text);
        String client_name = editText.getText().toString();

        //TODO: Send client_name to client class
        Client client = new Client(client_name, clientCounter, this);
        clientList.add(client);
        clientCounter++;

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.namePopUp);
        constraintLayout.setVisibility(View.GONE);

        editText.getText().clear();

        try {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch(Exception e) {
            Toast.makeText(this, "Couldn't close keyboard", Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelNaming(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.namePopUp);
        constraintLayout.setVisibility(View.GONE);

        EditText editText = (EditText) findViewById(R.id.client_name_text);
        editText.getText().clear();

        try {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } catch(Exception e) {
            Toast.makeText(this, "Couldn't close keyboard", Toast.LENGTH_SHORT).show();
        }
    }

}
