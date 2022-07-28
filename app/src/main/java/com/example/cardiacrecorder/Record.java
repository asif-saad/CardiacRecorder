package com.example.cardiacrecorder;

public class Record implements Comparable<Record>{

    Integer systolic, diastolic, heart;
    String date, time, comment;

    /**
     *
     * @param systolic
     * @param diastolic
     * @param heart
     * @param date
     * @param time
     * @param comment
     */
    public Record(Integer systolic, Integer diastolic, Integer heart, String date, String time, String comment) {
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.heart = heart;
        this.date = date;
        this.time = time;
        this.comment = comment;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int compareTo(Record record) {
        return 0;
    }
}
