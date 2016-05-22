package com.centaurusa.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Swin on 2016/5/22.
 */
public class NoteDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "note.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String BOOLEAN_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRYS = "CREATE TABLE" +
                    NoteEntry.TABLE_NAME + "(" +
                    NoteEntry._ID + TEXT_TYPE + "PRIMARY KEY" + COMMA_SEP +
                    NoteEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    NoteEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    NoteEntry.COLUMN_NAME_DETIAL + TEXT_TYPE + COMMA_SEP +
                    NoteEntry.COLUMN_NAME_CREATE_DATE + BOOLEAN_TYPE + COMMA_SEP +
                    NoteEntry.COLUMN_NAME_COMPLETED + BOOLEAN_TYPE + ")";

    public NoteDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRYS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
