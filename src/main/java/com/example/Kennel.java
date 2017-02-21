package com.example;

import java.util.Map;

/**
 * Created by Skinner on 2/20/17.
 */
public class Kennel {
    private String kennelName;
    private DataObject data;


    public String getKennelName() {
        return kennelName;
    }

    public void setKennelName(String kennelName) {
        this.kennelName = kennelName;
    }

    public DataObject getData() {
        return data;
    }

    public void setData(DataObject data) {
        this.data = data;
    }
}
