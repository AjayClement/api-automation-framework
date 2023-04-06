package com.ttt.apimodels;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MarksModel {

    @JsonProperty("sem-1")
    public SubjectModel sem1;

    @JsonProperty("sem-2")
    public SubjectModel sem2;

    @JsonProperty("sem-3")
    public SubjectModel sem3;

    public MarksModel() {
    }

    public MarksModel(SubjectModel sem1, SubjectModel sem2, SubjectModel sem3) {
        this.sem1 = sem1;
        this.sem2 = sem2;
        this.sem3 = sem3;
    }

    public SubjectModel getSem1() {
        return sem1;
    }

    public void setSem1(SubjectModel sem1) {
        this.sem1 = sem1;
    }

    public SubjectModel getSem2() {
        return sem2;
    }

    public void setSem2(SubjectModel sem2) {
        this.sem2 = sem2;
    }

    public SubjectModel getSem3() {
        return sem3;
    }

    public void setSem3(SubjectModel sem3) {
        this.sem3 = sem3;
    }

    @Override
    public String toString() {
        return "MarksModel{" +
                "sem1=" + sem1 +
                ", sem2=" + sem2 +
                ", sem3=" + sem3 +
                '}';
    }
}
