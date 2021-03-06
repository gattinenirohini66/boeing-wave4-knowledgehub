package com.stackroute.service;

public class POSTagging {
    private String originalWord;
    private String POSTag;

    public POSTagging() {
    }

    public POSTagging(String originalWord, String POSTag) {
        this.originalWord = originalWord;
        this.POSTag = POSTag;
    }

    /*getter method for originalWrd*/
    public String getOriginalWord() {
        return originalWord;
    }

    /*setter method for originalWord*/
    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    /*getter method for POSTag*/
    public String getPOSTag() {
        return POSTag;
    }

    /*setter method for POSTag*/
    public void setPOSTag(String POSTag) {
        this.POSTag = POSTag;
    }

    @Override
    public String toString() {
        return "POSTagging{" +
                "originalWord='" + originalWord + '\'' +
                ", POSTag='" + POSTag + '\'' +
                '}';
    }
}
