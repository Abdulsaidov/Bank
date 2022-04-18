package com.banksystem.core.entity;

public enum Locale {
    RUSSIAN("ru"),
    ENGLISH("en");

    private String localeCode;

    Locale(String localeCode) {
        this.localeCode = localeCode;
    }

    public String getLocaleCode() {
        return localeCode;
    }
}
