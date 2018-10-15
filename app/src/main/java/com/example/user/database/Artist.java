package com.example.user.database;

public class Artist {
    String id;
    String name;
    String gener;

    public Artist(String id, String name, String gener) {
        this.id = id;
        this.name = name;
        this.gener = gener;
    }

    public Artist()
    {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGener() {
        return gener;
    }
}

