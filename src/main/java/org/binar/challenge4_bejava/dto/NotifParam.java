package org.binar.challenge4_bejava.dto;

public enum NotifParam {
    SOUND("default"),
    COLOR("#FFFF00");

    private String value;

    NotifParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}