package com.example.cardiacrecorder;

public class Record {
    Integer systolic, diastolic, heart;
    String comment, date, time, id;

    public Record(Integer systolic, Integer diastolic, Integer heart, String comment, String date, String time, String id) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart = heart;
        this.comment = comment;
        this.date = date;
        this.time = time;
        this.id = id;
    }
}
