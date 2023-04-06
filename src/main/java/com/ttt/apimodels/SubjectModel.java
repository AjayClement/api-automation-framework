package com.ttt.apimodels;

public class SubjectModel {

    private int tamil;
    private int english;
    private int science;

    public SubjectModel() {


    }

    public SubjectModel(int tamil, int english, int science) {
        this.tamil = tamil;
        this.english = english;
        this.science = science;
    }
    public int getTamil() {
        return tamil;
    }

    public void setTamil(int tamil) {
        this.tamil = tamil;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "tamil=" + tamil +
                ", english=" + english +
                ", science=" + science +
                '}';
    }
}
