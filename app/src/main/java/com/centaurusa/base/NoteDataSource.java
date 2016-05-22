package com.centaurusa.base;

import android.support.annotation.NonNull;

import com.centaurusa.data.Note;

import java.util.List;

/**
 * Created by Swin on 2016/5/22.
 */
public interface NoteDataSource {
    interface LoadNotesCallback {
        void onNotesLoaded(List<Note> notes);
    }

    interface GetNoteCallback {
        void onNoteLoaded(Note note);
    }

    void getNotes(@NonNull LoadNotesCallback callback);

    void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback);

    void saveNote(@NonNull Note note);

    void refreshNotes();

    void deleteAllNotes();

    void deleteNotes(@NonNull String noteId);
}
