package com.centaurusa.data;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.widget.ListView;

import static com.google.common.base.Preconditions.checkNotNull;

import com.centaurusa.base.NoteDataSource;
import com.centaurusa.notedetial.NoteEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Swin on 2016/5/22.
 */
public class LocalNoteDataSource implements NoteDataSource {
    private static LocalNoteDataSource INSTANCE = null;
    private NoteDbHelper mNoteDbHelper;

    private LocalNoteDataSource(@NonNull Context context) {
        checkNotNull(context);
        mNoteDbHelper = new NoteDbHelper(context);
    }

    public static LocalNoteDataSource getIntance(@NonNull Context context) {
        checkNotNull(context);
        if (INSTANCE == null) {
            INSTANCE = new LocalNoteDataSource(context);
        }
        return INSTANCE;
    }

    @Override
    public void getNotes(@NonNull LoadNotesCallback callback) {
        List<Note> notes = new ArrayList<Note>();
        SQLiteDatabase db = mNoteDbHelper.getReadableDatabase();
        String[] columns = {
                NoteEntry.COLUMN_NAME_ENTRY_ID,
                NoteEntry.COLUMN_NAME_TITLE,
                NoteEntry.COLUMN_NAME_DETIAL,
                NoteEntry.COLUMN_NAME_CREATE_DATE,
                NoteEntry.COLUMN_NAME_COMPLETED
        };
        Cursor cursor = db.query(NoteEntry.TABLE_NAME, columns, null, null, null, null, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Note note = getNoteFromCursor(cursor);
                notes.add(note);
            }
        }
        callback.onNotesLoaded(notes);
    }

    @Override
    public void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback) {

    }

    @Override
    public void saveNote(@NonNull Note note) {
        checkNotNull(note);
        SQLiteDatabase db = mNoteDbHelper.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(NoteEntry.COLUMN_NAME_ENTRY_ID, note.getNoteId().toString());
        values.put(NoteEntry.COLUMN_NAME_TITLE, note.getTitle());
        values.put(NoteEntry.COLUMN_NAME_DETIAL, note.getDetial());
        values.put(NoteEntry.COLUMN_NAME_CREATE_DATE, note.getDate().getTime());
        values.put(NoteEntry.COLUMN_NAME_COMPLETED, note.isComplete());

        db.insert(NoteEntry.TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void refreshNotes() {

    }

    @Override
    public void deleteAllNotes() {

    }

    @Override
    public void deleteNotes(@NonNull String noteId) {

    }

    public Note getNoteFromCursor(Cursor cursor) {
        String noteId = cursor.getString(
                cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_ENTRY_ID));
        String noteTitle = cursor.getString(
                cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_TITLE));
        String noteDetial = cursor.getString(
                cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_DETIAL));
        Long noteCreateDate = cursor.getLong(
                cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_CREATE_DATE));
        boolean noteCompleted = cursor.getInt(
                cursor.getColumnIndexOrThrow(NoteEntry.COLUMN_NAME_COMPLETED)) == 1;

        Note note = new Note(noteId, noteTitle, noteDetial, noteCreateDate, noteCompleted);
        return note;
    }
}
