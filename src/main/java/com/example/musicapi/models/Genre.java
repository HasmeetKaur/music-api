package com.example.musicapi.models;

public enum Genre {
    BLUES("Blues"),
    COUNTRY("Country"),
    CONTEMPORARY("Contemporary"),
    ELECTRONIC("Electronic"),
    FOLK("Folk"),
    HIPHOP("Hip-hop"),
    JAZZ("Jazz"),
    POP("Pop"),
    FUNK("Funk"),
    RNB("RnB"),
    SOUL("Soul"),
    ROCK("Rock"),
    METAL("Metal"),
    ALTERNATIVE("Alternative");

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
