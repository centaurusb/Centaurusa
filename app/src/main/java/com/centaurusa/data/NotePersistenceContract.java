package com.centaurusa.data;

import android.provider.BaseColumns;

/**
 * Created by Swin on 2016/5/22.
 */
public final class NotePersistenceContract {

    public NotePersistenceContract() {
    }

    public static abstract class NoteEntry implements BaseColumns {
        public static final String TABLE_NAME = "note";
        public static final String COLUMN_NAME_ENTRY_ID = "noteid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DETIAL = "detial";
        public static final String COLUMN_NAME_CREATE_DATE = "createdate";
        public static final String COLUMN_NAME_COMPLETED = "completed";
    }
}
