package com.example.cardiacrecorder;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AddActivityTest {
    /**
     * create a Mock RecordList with one Record data
     * @return
     * returns a RecordList
     */
    private  RecordList mockRecordList() {
        RecordList recordList = new RecordList();
        recordList.add(mockRecord());
        return recordList;
    }

    /**
     * create a Mock Record
     * @return
     * returns created Mock Record
     */
    private Record mockRecord() {
        return new Record(88,78,101,"11-07-2022","14:01 am","no comment");
    }

    /**
     * checks if a record is added successfully on RecordList
     */
    @Test
    public void testAdd() {
        RecordList recordList = mockRecordList();
        assertEquals(1, recordList.getRecords().size());

        Record record = new Record(88,78,101,"11-07-2022","14:01 am","no comment");
        recordList.add(record);

        assertEquals(2, recordList.getRecords().size());
        assertTrue(recordList.getRecords().contains(record));
    }

    /**
     * checks if add function handle exception successfully
     */
    @Test
    public void testAddException() {
        RecordList recordList = new RecordList();
        Record record = mockRecord();
        recordList.add(record);

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.add(record);
        });
    }

}