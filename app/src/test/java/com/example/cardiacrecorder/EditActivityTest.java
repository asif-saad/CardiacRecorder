package com.example.cardiacrecorder;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditActivityTest {

    /**
     * Create a Mock RecordList with one Record data.
     * @return
     * returns a RecordList.
     */
    private  RecordList mockRecordList() {
        RecordList recordList = new RecordList();
        recordList.add(mockRecord());
        return recordList;
    }

    /**
     * Create a Mock Record
     * @return
     * returns created Mock Record
     */
    private Record mockRecord() {
        return new Record(88,78,101,"11-07-2022","14:01 am","no comment");
    }



    /**
     * Checks if getRecords return a List successfully
     */
    @Test
    public void testGetRecords() {
        RecordList recordList = mockRecordList();
        assertEquals(0, mockRecord().compareTo(recordList.getRecords().get(0)));

        Record record = new Record(88,78,101,"11-07-2022","14:01 am","no comment");

        assertEquals(0, record.compareTo(recordList.getRecords().get(1)));
        assertEquals(0, mockRecord().compareTo(recordList.getRecords().get(0)));
    }

    /**
     * checks if record is deleted successfully from RecordList
     */
    @Test
    public void testDelete() {
        RecordList temp = new RecordList();

        Record a = new Record(88,78,101,"11-07-2022","14:01 am","no comment");

        temp.add(a);
        temp.delete(a);

        assertFalse(temp.getRecords().contains(a));
    }

    /**
     * checks if delete function handle exception successfully
     */
    @Test
    public void testDeleteException() {
        RecordList temp = mockRecordList();

        Record record = new Record(88,78,101,"11-07-2022","14:01 am","no comment");

        assertThrows(IllegalArgumentException.class, () -> {
            temp.delete(record);
        });
    }





    /**
     * checks if update function handle exception in deleting successfully
     */
    @Test
    public void testUpdateExceptionDelete() {
        RecordList recordList = new RecordList();

        Record record1 = new Record(88,78,101,"11-07-2022","14:01 am","no comment");
        Record record2 = new Record(92,81,96,"22-06-2022","10:51 am","first comment");

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.update(record1, record2);
        });
    }

    /**
     * checks if update function handle exception in adding successfully
     */
    @Test
    public void testUpdateExceptionAdd() {
        RecordList recordList = new RecordList();

        Record record1 = new Record(88,78,101,"11-07-2022","14:01 am","no comment");
        Record record2 = new Record(92,81,96,"22-06-2022","10:51 am","first comment");

        recordList.add(record2);
        recordList.add(record1);
        assertThrows(IllegalArgumentException.class, () -> {
            recordList.update(record1, record2);
        });
    }

}