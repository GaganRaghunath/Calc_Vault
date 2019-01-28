package com.pirateapps.jack.calcvault;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper {

    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase db;
    private Cursor dbRecords;


    public DBHelper(Context context) {
        dbOpenHelper = new DBOpenHelper(context, DBOpenHelper.TABLE_NAME, null,
                1);
    }

    public void open() {
        if (db == null) {
            db = dbOpenHelper.getWritableDatabase();
        }
    }


    public void close() {
        if (db != null) {
            db.close();
        }
    }


    public void initialise() {
        open();
        getDBEntries();
    }


    public void getDBEntries() {
        dbRecords = db.query(DBOpenHelper.TABLE_NAME, new String[] { "id",
                "name", "number", "email" }, null, null, null, null, null);
    }


    public void refreshDBEntries() {
        int currentCursorPosition = dbRecords.getPosition();
        getDBEntries();

        dbRecords.move(currentCursorPosition);
    }


    private String[] getCurrentEntry() {
        String[] entry = new String[3];

        entry[0] = dbRecords.getString(1);
        entry[1] = dbRecords.getString(2);
        entry[2] = dbRecords.getString(3);

        return entry;
    }


    public String[] getFirstEntry() {
        if (dbRecords.moveToFirst()) {
            return getCurrentEntry();
        }

        return null;
    }


    public String[] getLastEntry() {
        if (dbRecords.moveToLast()) {
            return getCurrentEntry();
        }

        return null;
    }

    public String[] getNextEntry() {
        if (dbRecords.moveToNext()) {
            return getCurrentEntry();
        } else {
            dbRecords.moveToLast();
        }

        return null;
    }


    public String[] getPreviousEntry() {
        if (dbRecords.moveToPrevious()) {
            return getCurrentEntry();
        } else {

            dbRecords.moveToFirst();
        }

        return null;
    }


    public Boolean deleteCurrentEntry() {
        int cursorId;

        try {
            cursorId = dbRecords.getInt(0);
        } catch (Exception e) {
            return false;
        }

        int deleteRecord = db.delete(DBOpenHelper.TABLE_NAME, "id = "
                + cursorId, null);

        if (deleteRecord > 0) {
            refreshDBEntries();

            return true;
        }

        return false;
    }


    public Boolean addNewEntry(String name, String number, String email) {
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("number", number);
        cv.put("email", email);

        long insertRecord = db.insert(DBOpenHelper.TABLE_NAME, null, cv);

        return (insertRecord != -1);
    }
}
