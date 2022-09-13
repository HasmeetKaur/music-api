package com.example.musicapi.models;

public enum Genre {
    JAZZ("Jazz"),
    ROCK("Rock"),
    BLUES("Blues"),
    COUNTRY("Country"),
    CLASSICAL("Classical"),
    ELECTRONIC("Electronic"),
    HIPHOP("Hip-hop"),
    METAL("Metal"),
    ALTERNATIVE("Alternative"),
    SOUL("Soul"),
    RNB("RnB"),
    FOLK("Folk"),
    POP("Pop"),
    FUNK("Funk");

    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

