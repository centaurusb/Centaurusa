package com.centaurusa.data;

import android.support.annotation.NonNull;

import com.centaurusa.base.NoteDataSource;

/**
 * Created by Swin on 2016/5/22.
 */
public class NoteDataRepository implements NoteDataSource {
    private static NoteDataRepository INSTANCE = null;
    //    private final RemoteNoteDataSource mRemoteDataSource;
    private final LocalNoteDataSource mLocalDataSource;

    private NoteDataRepository(@NonNull LocalNoteDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    public static NoteDataRepository getInstance(LocalNoteDataSource localDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new NoteDataRepository(localDataSource);
        }
        return INSTANCE;
    }

    public static void destoryInstance(){
        INSTANCE = null;
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
