package com.example.cardiacrecorder;

public class Record implements Comparable<Record> {

    Integer systolic,diastolic,heart;
    String comment, data, time;

    public Record(Integer systolic, Integer diastolic, Integer heart, String comment, String data, String time) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart = heart;
        this.comment = comment;
        this.data = data;
        this.time = time;
    }

    public Integer getSystolic() {
        return systolic;
    }

    public void setSystolic(Integer systolic) {
        this.systolic = systolic;
    }

    public Integer getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Integer diastolic) {
        this.diastolic = diastolic;
    }

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Record record) {
        return this.systolic.compareTo(record.getSystolic());
    }
}
