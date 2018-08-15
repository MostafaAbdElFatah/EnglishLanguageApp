package com.mostafa.fci.languageapp;

public class Word {
    private String arabic;
    private String english;
    private int imageResourceId;

    public Word(){}

    public Word(String arabic, String english, int imageResourceId ) {
        this.arabic = arabic;
        this.english = english;
        this.imageResourceId = imageResourceId;
    }

    public String getArabic() {
        return arabic;
    }

    public void setArabic(String arabic) {
        this.arabic = arabic;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

}
