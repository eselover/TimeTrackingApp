package test.erics.timetracking;


import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by erics on 6/8/2017.
 */

class Client {

    private String name;
    private int id;
    private boolean isActive = false;
    private int sec;
    private Context context;
    private ArrayList<TimeObject> times = new ArrayList<TimeObject>();



    public Client(String name, int id, Context context){
        this.name = name;
        this.id = id;
        this.context = context;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void startTracking() {
        isActive = true;
        final Handler h = new Handler();
        final int delay = 1000;

        h.postDelayed(new Runnable() {
           public void run() {
               sec++;
               if(isActive) {
                   h.postDelayed(this, delay);
               }
           }
        }, delay);
    }

    public void stopTracking() {
        isActive = false;
        TimeObject timeObj = new TimeObject(sec);
        times.add(timeObj);
        sec = 0;
    }

    public void attachNote() {
        //TODO: Add a note to a specific time
    }

}
