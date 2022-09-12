package com.example.musicapi.models;

public class Reply {

    private boolean passed;
    private String message;

    public Reply(boolean passed, String message) {
        this.passed = passed;
        this.message = message;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
