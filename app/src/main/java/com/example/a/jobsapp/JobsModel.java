package com.example.a.jobsapp;

public class JobsModel {
    private String title;
    private String location;
    private String how_to_apply;

    public JobsModel(String location, String title, String how_to_apply) {
        this.location=location;
        this.title=title;
        this.how_to_apply=how_to_apply;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHow_to_apply() {
        return how_to_apply;
    }

    public void setHow_to_apply(String how_to_apply) {
        this.how_to_apply = how_to_apply;
    }
}
