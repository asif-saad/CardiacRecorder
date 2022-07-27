package com.example.cardiacrecorder;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainActivityTest {

    /**
     * Creates a Mock RecordList with one Record data.
     * @return
     * returns a RecordList
     */
    private  RecordList mockRecordList() {
        RecordList recordList = new RecordList();
        recordList.add(mockRecord());
        return recordList;
    }

    /**
     * Creates a Mock Record.
     * @return
     * returns created Mock Record.
     */
    private Record mockRecord() {
        return new Record(88,78,101,"11-07-2022","14:01 am","no comment");
    }




    /**
     * Checks if countRecords function can count records on RecordList successfully.
     */
    @Test
    public void testcountRecords() {
        RecordList recordList = mockRecordList();

        Record record1 = new Record(88,78,101,"11-07-2022","14:01 am","no comment");
        Record record2 = new Record(92,81,96,"22-06-2022","10:51 am","first comment");
        Record record3 = new Record(101,95,78,"18-07-2022","09:04 am",null);

        recordList.add(record1);
        recordList.add(record2);
        recordList.add(record3);
        assertEquals(4, recordList.countRecords());
    }

}