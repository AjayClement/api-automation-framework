package com.ttt.apimodels;

import java.util.List;

public class StudentsModel {

    private int id;
    private String name;
    private MarksModel marks;
    private List<String> hobbies;

    public StudentsModel() {
    }

    public StudentsModel(int id, String name, MarksModel marks, List<String> hobbies) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarksModel getMarks() {
        return marks;
    }

    public void setMarks(MarksModel marks) {
        this.marks = marks;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "StudentsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", hobbies=" + hobbies +
                '}';
    }
}
