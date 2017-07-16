package test.erics.timetracking;

import java.util.ArrayList;

/**
 * Created by erics on 6/9/2017.
 */

class TimeObject {

    public long time;
    public int hours, min, sec;
    public String note;
    public ArrayList<String> notes = new ArrayList<String>();

    public TimeObject() {}
    public TimeObject(int time) {
        this.time = time;
        convertTime(time);
    }
    public TimeObject(int hours, int min, int sec) {
        this.hours = hours;
        this.min = hours;
        this.sec = hours;
    }

    public void addNote(String note) {
        this.note = note;
        notes.add(note);
    }

    private void convertTime(int time) {
        hours = time / 3600;
        min = (time % 3600) / 60;
        sec = time % 60;
    }

}
