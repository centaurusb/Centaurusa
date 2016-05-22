package com.centaurusa.data;

/**
 * Created by Swin on 2016/5/22.
 */
public class RemoteNoteDataSource {
    private static RemoteNoteDataSource INSTANCE = null;

    private RemoteNoteDataSource(){
    }

    public static RemoteNoteDataSource getInstance(){
        if(INSTANCE == null){
            INSTANCE = new RemoteNoteDataSource();
        }
        return INSTANCE;
    }
}
