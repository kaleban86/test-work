package com.technology.testwork.dto;


public class CreateLanguageDto {


    private String state;
    private LanguageDto body;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LanguageDto getBody() {
        return body;
    }

    public void setBody(LanguageDto body) {
        this.body = body;
    }

}
