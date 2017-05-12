package com.example.sunil.restapplication;

/**
 * Created by sunil on 12/05/17.
 */

public class Person {
    private int userID,id;
    private String title;

    public Person(int userID, int id, String title) {
       this.setUserID(userID);
        this.setId(id);
        this.setTitle(title);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
