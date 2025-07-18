package com.example.myapplication.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable {

    private String title;
    private String address;
    private String description;
    private String pic;
    private String duration;

    public String getdateTour() {
        return dateTour;
    }

    public void setdateTour(String dateTour) {
        this.dateTour = dateTour;
    }

    public String getTimetour() {
        return timetour;
    }

    public void setTimetour(String timetour) {
        this.timetour = timetour;
    }

    private String dateTour;
    private String timetour;
    private String ateTour;
    private String tourGuideName;
    private String tourGuidePic;
    private String tourGuidePhone;
    private String distance;
    int price,bed;
    double score;

    public ItemDomain() {
    }

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public String getAteTour() {
        return ateTour;
    }

    public void setAteTour(String ateTour) {
        this.ateTour = ateTour;
    }

    public String getTourGuideName() {
        return tourGuideName;
    }

    public void setTourGuideName(String tourGuideName) {
        this.tourGuideName = tourGuideName;
    }

    public String getTourGuidePic() {
        return tourGuidePic;
    }

    public void setTourGuidePic(String tourGuidePic) {
        this.tourGuidePic = tourGuidePic;
    }

    public String getTourGuidePhone() {
        return tourGuidePhone;
    }

    public void setTourGuidePhone(String tourGuidePhone) {
        this.tourGuidePhone = tourGuidePhone;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
