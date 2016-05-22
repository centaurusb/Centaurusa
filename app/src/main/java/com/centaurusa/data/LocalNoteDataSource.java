package com.centaurusa.data;


import android.support.annotation.NonNull;

import com.centaurusa.base.NoteDataSource;

/**
 * Created by Swin on 2016/5/22.
 */
public class LocalNoteDataSource implements NoteDataSource {
    private static LocalNoteDataSource INSTANCE = null;

    private LocalNoteDataSource() {

    }
    public static LocalNoteDataSource getIntance(){
        if(INSTANCE == null){
            INSTANCE = new LocalNoteDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getNotes(@NonNull LoadNotesCallback callback) {

    }

    @Override
    public void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback) {

    }

    @Override
    public void saveNote(@NonNull Note note) {

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
}
